class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;        
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                //nums[i]和nums[j]不相等, nums[i+1] = nums[j]
                nums[++i] = nums[j];             
            }
        }
        return i+1; //最后的长度就是i, i为下标需要+1处理
    }
}