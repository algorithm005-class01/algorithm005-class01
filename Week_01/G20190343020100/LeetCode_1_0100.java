package com.algorithm.week01;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for (int i = 0; i < nums.length; ++i) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{i,map.get(target - nums[i])};
      }
      map.put(nums[i],i);
    }
    return null;
  }
}
//runtime:6 ms
//memory:39.1 MB
