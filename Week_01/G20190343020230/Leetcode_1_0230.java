package week01;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1_0230 {

//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]

    // 暴力法
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{};
//    }

    // 哈希表，时间复杂度从O(n)降到O(1)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 18;
        int[] nums = new int[]{3, 2, 3};
        int target = 6;
        Leetcode_1_0230 test = new Leetcode_1_0230();
        test.twoSum(nums, target);
    }
}