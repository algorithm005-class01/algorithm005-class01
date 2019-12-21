package RotateArray189;

/**
 * https://leetcode.com/problems/rotate-array/
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author yx101 (David Qu)
 *
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    // 反转法：时间复杂度 O(n) 空间复杂度 O(1)
    public void rotate(int[] nums, int k) {
        // 边界检查
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }

        int n = nums.length;

        k %= n;
        rotateRange(0, n - k - 1, nums);
        rotateRange(n - k, n - 1, nums);
        rotateRange(0, n - 1, nums);
    }

    private void rotateRange(int start, int end, int[] array) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(array, i, j);
        }
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // 暴力：时间复杂度 O(n∗k) 空间复杂度 O(1)
    public void rotate2(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {// 外循环，旋转 k 次
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {// 内循环，每次将数组旋转 1 个元素
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
