class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int k = 0;
        for ( int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }
}