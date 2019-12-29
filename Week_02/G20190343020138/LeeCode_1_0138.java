package com.log8.week02;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null||"null".equals(String.valueOf(target))){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,11,  7, 15};
        Solution1 s1 = new Solution1();
        int[] result = s1.twoSum(nums,9);
        System.out.println(result[0]+"----"+result[1]);
    }
}
