package week_01.commit;

import java.util.HashMap;
import java.util.Map;

// 两数之和
// https://leetcode-cn.com/problems/two-sum/
public class Solution_01 {
    // 暴力法
    private int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // hash解法
    private int[] twoSum2s(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int x = target - nums[i];
            if(map.containsKey(x) && map.get(x) != i){
                result[0] = i;
                result[1] = map.get(x);
            }
        }
        return result;
    }
}
