/*
 * @lc app=leetcode.cn id=55 lang=cpp
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (37.11%)
 * Likes:    408
 * Dislikes: 0
 * Total Accepted:    49.1K
 * Total Submissions: 132K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3
 * 步到达最后一个位置。
 *
 *
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 *
 *
 */

// @lc code=start
class Solution {
  public:
    bool canJump(vector<int> &nums) {
        // // 1. 遍历
        // int prevMax = 0;
        // for (int i = 0; i < nums.size(); ++i) {
        //     if (i > prevMax) {
        //         return false;
        //     }
        //     prevMax = max(prevMax, i + nums[i]);
        // }
        // return true;

        // 2. 从后向前遍历
        int lastPos = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; --i) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
};
// @lc code=end
