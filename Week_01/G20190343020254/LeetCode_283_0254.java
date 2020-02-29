class Solution {
    private int zeroCount = 0;
    public void moveZeroes(int[] nums) {
        int curIndex = 0;
        while (curIndex < nums.length) {
            if (nums[curIndex] == 0) {
                zeroCount++;
                curIndex++;
                continue;
            }
            nums[curIndex - zeroCount] = nums[curIndex];
            curIndex++;
        }
        Arrays.fill(nums, nums.length - zeroCount, nums.length, 0);
    }
}