class Solution {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[current]!=nums[i]) {
                nums[++current] = nums[i];
            }
        }
        return ++current;
    }
}