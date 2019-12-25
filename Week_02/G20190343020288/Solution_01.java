package week_02.commit;

import java.util.HashMap;
import java.util.Map;

// 1. 两数之和
// https://leetcode-cn.com/problems/two-sum/
public class Solution_01 {

    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x) && map.get(x) != i) {
                return new int[]{i, map.get(x)};
            }
        }
        return null;
    }
}
