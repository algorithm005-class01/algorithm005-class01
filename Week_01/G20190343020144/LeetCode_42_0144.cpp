// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 示例:

// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出: 6

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

/**
 * 有凹陷才会有可能接雨水
 * 所以首先求 diff 差值数组
 * 
*/
class Solution
{
public:
    int trap(vector<int> &height)
    {
        int ans = 0, current = 0;
        stack<int> st;
        while (current < height.size())
        {
            // pop 栈的条件, 比栈顶高才pop , 否则一直压栈, 低的不是接雨水-水坑的边界
            while (!st.empty() && height[current] > height[st.top()])
            {
                int top = st.top();
                st.pop();
                // 排除只是上升的情况
                if (st.empty())
                    break;
                int distance = current - st.top() - 1;
                cout << current << ": " << st.top() << ": " << distance << endl;

                int bounded_height = min(height[current], height[st.top()]) - height[top];
                cout << bounded_height << endl;
                // 计算的是规则图形的面积, 而不是不规则的算法
                ans += distance * bounded_height;
                cout << distance * bounded_height << "----" << endl;
            }
            st.push(current++);
        }
        return ans;
    }
};

/**
 * 求指定元素 左右两侧的 最大高度 ,会对某个位置重复计算. 
 * 算是 暴力求解
*/
class SolutionN2
{
public:
    int trap(vector<int> &height)
    {
        // 接雨水是要有坑才可以, 在 height[i]的柱子,它能存多少水由其左侧的最大高度和右侧的最大高度以及本身的高度来决定的
        int ans = 0, leftMax = 0, rightMax = 0;
        // 注意边界是 [1,size - 1], 边界肯定没有水
        for (int i = 1; i < height.size() - 1; i++)
        {
            //找出i左右的柱子最大高度
            leftMax = 0, rightMax = 0;
            // 注意边界 应该是 [0,i], 边界一定要包含 i , 因为i如果最高 那么不会存水,不能忽略该位置
            for (int l = 0; l <= i; l++)
            {
                leftMax = max(leftMax, height[l]);
            }
            // 注意边界 应该是 [i,size - 1] , 边界一定要包含 i
            for (int r = height.size() - 1; r >= i; r--)
            {
                rightMax = max(rightMax, height[r]);
            }
            // 计算该柱子的存水
            ans += min(leftMax, rightMax) - height[i];
        }
        return ans;
    }
};

/**
 * 重复计算的问题 经常会使用动态规划的方式 进行优化, 避免重复计算
 * 
*/
class Solution2N
{
public:
    int trap(vector<int> &height)
    {
        // 接雨水是要有坑才可以, 在 height[i]的柱子,它能存多少水由其左侧的最大高度和右侧的最大高度以及本身的高度来决定的
        if (height.size() < 3)
            return 0;

        int ans = 0, leftMax = 0, rightMax = 0, size = height.size();
        // 注意边界是 [1,size - 1], 边界肯定没有水
        // 定义dpl[i] 为 左侧连续数组中 最大高度
        vector<int> dpl = vector<int>(size), dpr = vector<int>(size);
        dpl[0] = height[0];
        dpr[size - 1] = height[size - 1];

        for (int i = 1; i < size - 1; i++)
        {
            // 左侧最大 从左往右遍历
            dpl[i] = max(dpl[i - 1], height[i]);
            // 右侧最大 从右往左遍历
            dpr[size - i - 1] = max(dpr[size - i], height[size - i - 1]);
        }

        // 两侧最大高度已经计算完毕
        for (int i = 1; i < height.size() - 1; i++)
        {
            // 计算该柱子的存水
            ans += min(dpl[i], dpr[i]) - height[i];
        }
        return ans;
    }
};

/**
 * 对于上面的 Solution2N 动态规划的方式 进行优化, 也就是说 如何不存储 n 个 最大高度,而仅仅只用一个或者常数个呢
 *  分析 Solution2N 以及 接水的原理, 发现 对于 height[i] 的柱子, 如果左侧最大元素,小于i 右侧的元素, 那么不论右侧元素为哪一个, height[i] 柱子的接水量都取决于左侧最高与自身高度. 
 * 同理可得右侧柱子. 
 * 那么可以采用双指针夹逼法 计算
 * >>>>>>>> 自己经常犯的错误是 双指针法 对于右侧是 r--; 而不是 r++; <<<<<<
*/
class SolutionN
{
public:
    int trap(vector<int> &height)
    {
        // 接雨水是要有坑才可以, 在 height[i]的柱子,它能存多少水由其左侧的最大高度和右侧的最大高度以及本身的高度来决定的
        if (height.size() < 3)
            return 0;

        int ans = 0, size = height.size(), l = 0, r = size - 1, leftMax = height[0], rightMax = height[size - 1];
        // 注意边界是 [1,size - 1], 边界肯定没有水
        while (l < r)
        {
            // 比较左右两个元素 哪个大, 从小的那一个柱子开始计算
            if (height[l] < height[r])
            {
                if (height[l] > leftMax)
                {
                    leftMax = height[l++];
                }
                else
                {
                    ans += leftMax - height[l++];
                }
            }
            else
            {
                if (height[r] > rightMax)
                {
                    rightMax = height[r--];
                }
                else
                {
                    ans += rightMax - height[r--];
                }
            }
        }
        return ans;
    }
};

void printArr(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << ",";
    }
    cout << endl;
};

int main(int argc, char **argv)
{
    vector<vector<int>> arrs;
    arrs.push_back({0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

    for (auto arr : arrs)
    {
        printArr(arr);
        cout << SolutionN().trap(arr) << endl;
    }
    return -1;
}