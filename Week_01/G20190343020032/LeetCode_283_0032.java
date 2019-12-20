class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }
    }
}