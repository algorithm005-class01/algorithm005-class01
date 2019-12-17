class Leecode_283_0116 {

    /**
     *两个index下角标，将非0的补上,最后再补0
     */
    public void moveZeroes(int[] nums) {
        int index = 0;

        for( int i = 0 ; i< nums.length ; i++){
            if(nums[i] != 0){
                nums[index]= nums[i];
                index ++;
            }
        }
        for( int i= index ; i < nums.length ; i++){
            nums[index] = 0;
        }
    }
}