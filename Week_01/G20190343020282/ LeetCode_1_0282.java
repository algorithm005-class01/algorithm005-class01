package com.demo.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 * @author houyujia
 * @since 2019/12/15
 */
public class twosum1 {
    public static void main(String[] args) {
        int[] a=new int[]{2, 7, 11, 15};
        int target=9;
        method1(a,target);
    }

    /**
     * 解法一 暴力遍历
     * 时间复杂度 O（n^2）
     * @param nums
     * @param target
     * @return
     */
    private static int[] method1(int[] nums, int target) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i]+nums[j]==target){
                    System.out.println("["+i+","+j+"]");
                    return new int[] { i, j };

                }
            }
        }
        throw new IllegalArgumentException("No");
    }
    /**
     * 解法二 用hashmap保存数组的值和索引，当符合条件时 return
     * 时间复杂度 O（n）
     * @param nums
     * @param target
     * @return
     */
    private static int[] method2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No");

    }
}
