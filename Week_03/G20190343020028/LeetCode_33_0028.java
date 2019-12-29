//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 边界值判断
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 如果中间值即目标值，则返回中值下标
            if (nums[mid] == target) {
                return mid;
            }

            // 左侧有序的情况
            if (nums[start] < nums[mid]) {
                // 目标值在该区间内，则继续向内查找
                if (nums[start] <= target && target <= nums[mid]){
                    end = mid;
                } else { // 否则向右查找
                    start = mid;
                }
            } else if (nums[mid] < nums[end]) { // 右侧有序的情况
                // 目标值在该区间
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        // 仅剩余 1 或 2 元素的情况下，判断两边界值是否为目标值
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else { // 没找到目标值，则返回 -1
            return -1;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
