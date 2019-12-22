/*
 * @lc app=leetcode.cn id=42 lang=cpp
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (47.19%)
 * Likes:    716
 * Dislikes: 0
 * Total Accepted:    41.1K
 * Total Submissions: 86.7K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
#include<vector>
#include<stack>

using namespace std;
class Solution {
public:
    //暴力解法
    int trap1(vector<int>& height) {
        int count = height.size();
        // if (count <= 2) return 0;
        int ans = 0;
        for (int i = 1; i < count-1; i++) {
            int maxLeft = 0,maxRight = 0;
            for (int l = i; l >= 0; l--) {
                maxLeft = max(maxLeft, height[l]);
            }
            for (int r = i; r < count; r++) {
                maxRight = max(maxRight, height[r]);
            }
            ans += min(maxLeft, maxRight)-height[i];
        }
        return ans;
    }
    // 动态规划法
    int ans = 0, size = height.size();
        if (size == 0) return 0;
        vector<int> maxLeft(size); // 注意height为空的情况
        maxLeft[0] = height[0];
        for (int i = 1; i< size; i++) {
            maxLeft[i] = max(maxLeft[i-1], height[i]);
        }
        vector<int> maxRight(size);
        maxRight[size-1] = height[size-1];
        for (int i = size - 2; i >=0; i--) {
            maxRight[i] = max(maxRight[i+1], height[i]);
        }
        for (int i = 0; i < size; i++) {
            ans += min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    // 栈
    int trap(vector<int>& height) {

        int ans = 0;
        int size = height.size();
        stack<int> theStack;
        for (int i = 0;i < size;i++) {
            while (!theStack.empty() && height[i] > height[theStack.top()]) {
                int top = theStack.top();
                theStack.pop();
                if (theStack.empty()) break;
                /*i 和 theStack.top()界定了 top的边界，
                如果top与i之间还有元素，这些元素的高度小于等于top元素的高度，
                这些元素只填充了低于top的水，但是top不是该元素的maxLeft，
                所以top可以被填满的空间其他元素也可被填满，
                所以需要计算这些元素的宽度然后乘以可被填充的高度，
                计算出横向的水。*/
                int distance = i - theStack.top() - 1; 
                int boundedHeight = min(height[i],height[theStack.top()])-height[top]; // 
                ans += distance * boundedHeight;
            }
            theStack.push(i);
        }
        
        return ans;
   }
};
// @lc code=end

