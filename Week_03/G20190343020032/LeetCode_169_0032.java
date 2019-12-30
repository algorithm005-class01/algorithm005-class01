class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return nums[leftIndex];
        }

        int mid = (rightIndex - leftIndex) / 2 + leftIndex;
        int left = majorityElement(nums, leftIndex, mid);
        int right = majorityElement(nums, mid + 1, rightIndex);

        if (left == right) {
            return left;
        }

        int leftCount = count(nums, left, leftIndex, rightIndex);
        int rightCount = count(nums, right, leftIndex, rightIndex);
        return leftCount <= rightCount ? right : left;
    }

    private int count(int[] nums, int target, int leftIndex, int rightIndex) {
        int count = 0;
        for (; leftIndex <= rightIndex; leftIndex++) {
            if (nums[leftIndex] == target) {
                count++;
            }
        }
        return count;
    }
}