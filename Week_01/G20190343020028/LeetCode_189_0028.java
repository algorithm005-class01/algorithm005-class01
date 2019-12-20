//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        // 真正需要循环右移的次数
        k = k % nums.length;
        // 如果需要移动的次数为 0，直接返回
        if (k == 0) {
            return;
        }
        // 先将整个数组反转
        reverse(nums, 0, nums.length - 1);
        // 其次分别将前 k 个元素，之后的元素反转
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 将数组段进行反转
     *
     * @param nums  数组
     * @param start 反转起始位置
     * @param end   反转终止位置
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int swap = nums[start];
            nums[start] = nums[end];
            nums[end] = swap;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
