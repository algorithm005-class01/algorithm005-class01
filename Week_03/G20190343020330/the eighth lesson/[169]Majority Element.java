//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = lo + (hi - lo) / 2;

        int left = helper(nums, lo, mid);
        int right = helper(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countMajority(nums, left, lo, hi);
        int rightCount = countMajority(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;

    }

    public int countMajority(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
