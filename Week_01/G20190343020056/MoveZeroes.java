class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                count++;
            } else {
                nums[i - count] = nums[i]; //前移的思想，前移的位数为count，有几个 0 ，就向前面移动几位
            }
        }
        
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}