//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        // 使用双指针，将快指针遇到的非零元素与 0 值元素交换
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            // 快指针找到非零元素
            if (nums[fast] != 0) {
                // 快慢指针不是同一元素
                if (fast != slow) {
                    // 慢指针修改为非零元素
                    nums[slow] = nums[fast];
                    // 快指针修改为 0
                    nums[fast] = 0;
                }
                // 慢指针前进
                slow++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
