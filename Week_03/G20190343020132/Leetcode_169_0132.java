package org.azai.train.Week03;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_169_0132 {
    //哈希表
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int cur : nums) {
            if (map.containsKey(cur)) {
                map.put(cur,map.get(cur)+1);
            } else {
                map.put(cur,1);
            }
            if (map.get(cur)>(nums.length/2)) {
                return cur;
            }
        }
        return 0;
    }
    //摩尔投票法
    public int majorityElement1(int[] nums) {
        int more = nums[0];
        int count = 1;
        for (int i = 1;i < nums.length;i++) {
            count = more == nums[i] ? count+1 : count-1;
            if (count == 0) {
                more = nums[++i];
                count = 1;
            }
        }
        return more;
    }
}
