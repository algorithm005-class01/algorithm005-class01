package com.android.browser.newhome.news.login;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1_0010 {

    class Solution {

        // public int[] twoSum(int[] nums, int target) {
        //     Map<Integer, Integer> map = new HashMap();

        //     for(int i  = 0; i < nums.length; i++){
        //         int outputSize = target - nums[i];
        //         if(map.containsKey(outputSize)){
        //             return new int[] {map.get(outputSize), i};
        //         }

        //         map.put(nums[i],i);
        //     }

        // return null;

        // }


        //暴力抗双层排序
        // public int[] twoSum(int[] nums, int target) {
        //     for(int i = 0 ; i < nums.length -1; i++){
        //         for(int j = i+1; j < nums.length; j++){
        //             if(nums[i] + nums[j] == target){
        //                 return new int[]{i, j};
        //             }
        //         }
        //     }
        //     return null;
        // }

        //如果是排序好的数组，那么可以采用首尾向中间夹逼的方法；
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0, j = nums.length - 1; j > 0; ) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                } else if (nums[i] + nums[j] > target) {
                    j--;
                } else {
                    i++;
                }

            }
            return null;
        }

    }
}
