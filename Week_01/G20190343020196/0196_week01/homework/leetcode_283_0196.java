/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start

/* ##笔记：
+ 同样解法，java比js快很多
+ 指针定位
+ 位置互换 */

class Solution {
    //1.自己的解法
    // public void moveZeroes(int[] nums) {
    //    
    //     int firstZero = -1;
    //     for (int i = 0; i < nums.length; i++) {
    //         //找到首0
    //         if (nums[i] == 0 && firstZero == -1) {
    //             firstZero = i;
    //         }
    //         //遇到非0且找到首0，开始替换
    //         if (nums[i] != 0 && firstZero != -1) {
    //             nums[firstZero++] = nums[i];
    //             nums[i] = 0;
    //         }
    //     }
    // }
    
    //2.网上的解法，更优
/*     public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //非0
            if (nums[i] != 0) {
                //换位
                nums[j] = nums[i];
                //还没遇到零
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    } */

    public static void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for(int i = 0; i< nums.length; i++){
            //记录0球的大小
            if(nums[i] == 0){
                snowBallSize++;
            }
            //找到0
            else if(snowBallSize > 0){
                //替换
                nums[i - snowBallSize] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
// @lc code=end