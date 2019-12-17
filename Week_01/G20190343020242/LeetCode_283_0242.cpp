/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (58.14%)
 * Likes:    446
 * Dislikes: 0
 * Total Accepted:    88.3K
 * Total Submissions: 151.8K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0
 * 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 *
 */

// @lc code=start
class Solution {
  public:
    void moveZeroes(vector<int> &nums) {
        for (int i = 0, cur = 0; cur < nums.size(); cur++) {
            if (nums[cur] != 0) {
                if (nums[cur] != 0) {
                    swap(nums[cur], nums[i++]);
                }
            }
        }
    }
};
// @lc code=end
