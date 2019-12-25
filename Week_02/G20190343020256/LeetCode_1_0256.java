package Week2;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class LeetCode_1_0256 {

    public int[] twoSum(int[] nums, int target) {
        return twoSumByCycle(nums, target);
    }


    // a, target-a
    private int[] twoSumByCycle(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int[] twoSumByMap(int[] nums, int target) {
        // key = nums 中的数，value = 下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[] {i, map.get(num)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int[] twoSumByMap2(int[] nums, int target) {
        // key = nums 中的数，value = 下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] {i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
