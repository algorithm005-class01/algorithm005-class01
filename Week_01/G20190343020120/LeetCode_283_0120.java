class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}