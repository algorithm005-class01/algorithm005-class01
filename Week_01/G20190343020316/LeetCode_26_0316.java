class LeetCode_26_0316 {
    public void moveZeroes(int[] nums) {
        int j = 0  ;
        for(int i = 0 ; i< nums.length ;i++){
            if(nums[i]!=0) {
                int tmp = nums[j];
                nums[j] = nums[i] ;
                nums[i] = tmp ;
                j++ ;
            }

        }
    }
}