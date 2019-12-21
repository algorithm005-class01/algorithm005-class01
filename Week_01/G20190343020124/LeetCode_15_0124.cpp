/*
 * @lc app=leetcode.cn id=15 lang=cpp
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.58%)
 * Likes:    1593
 * Dislikes: 0
 * Total Accepted:    128.2K
 * Total Submissions: 519.6K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
public:
// 双指针夹逼
    std::vector<std::vector<int>> threeSum(std::vector<int>& nums) {
        std::vector<std::vector<int>> ret;
        if (nums.size() < 3) {
            return ret;
        }
        std::sort(nums.begin(), nums.end());
        int k = 0;
        while (k < nums.size()-2) {
            int i = k+1, j = nums.size()-1;
            while (i<j) {
                if (nums[k] > 0) break;
                if (k > 0 && nums[k] == nums[k-1]) break;
                if (nums[k] + nums[i] + nums[j] < 0) {
                    i++;
                } else if (nums[k] + nums[i] + nums[j] >0) {
                    j--;
                } else {
                    ret.push_back({nums[k], nums[i], nums[j]});
                    while (i<j && nums[i] == nums[++i]) {}
                    while (i<j && nums[j] == nums[--j]){}
                }
            }
            k++;
        }
        return ret;
    }
    // 暴力解法 
    vector<vector<int>> threeSum1(vector<int>& nums) {
        std::vector<int> vec;
        std::set<std::vector<int>> set;
        std::vector<std::vector<int>> ret; // set 去重
        if (nums.size() < 3) {
            return ret;
        }
        for (int i = 0; i < nums.size() - 2; i++)
        {
            for (int j = i + 1; j < nums.size() - 1; j++)
            {
                for (int k = j + 1; k < nums.size(); k++)
                {

                    if (nums[i] + nums[j] + nums[k] == 0)
                    {
                        int a=(nums[i]<nums[j]?nums[i]:nums[j])<nums[k]?(nums[i]<nums[j]?nums[i]:nums[j]):nums[k];//放最小的元素
                        int b=(nums[i]>nums[j]?nums[i]:nums[j])>nums[k]?(nums[i]>nums[j]?nums[i]:nums[j]):nums[k];//放最大的元素
                        int c=0-a-b;
                        
                        set.insert({a, b, c});
                    }
                }
            }
        }
        for (auto it : set)
        {
            ret.push_back(it);
        }
        return ret;
    }
};
// @lc code=end

