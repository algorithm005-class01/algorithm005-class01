/*
 * @lc app=leetcode.cn id=78 lang=cpp
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.46%)
 * Likes:    419
 * Dislikes: 0
 * Total Accepted:    50.9K
 * Total Submissions: 67.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> subRes;
        subsetsDfs(0, nums, res, subRes);
        return res;
    }
    
    void subsetsDfs(int start,vector<int> &nums, vector<vector<int>> &res, vector<int> &subRes) {
        res.push_back(subRes);
        for(int i=start;i<nums.size();i++) {
            subRes.push_back(nums[i]);
            subsetsDfs(i+1,nums, res, subRes);
            subRes.pop_back();
        }
    }
};
// @lc code=end

