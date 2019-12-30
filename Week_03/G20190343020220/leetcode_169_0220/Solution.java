package Week_03.G20190343020220.leetcode_169_0220;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Darcy
 * @date 2019-12-27 14:00
 */
public class Solution {
    public int majorityElement1(int[] nums) {
        return majorityHelper(nums, 0, nums.length - 1);
    }

    private int majorityHelper(int[] nums, int lo, int hi) {
        if (nums.length == 0) {
            return 0;
        }
        if (lo == hi) {
            return nums[lo];
        }
        /*且中间值*/
        int mid = (hi - lo) / 2 + lo;
        int left = this.majorityHelper(nums, lo, mid);
        int right = this.majorityHelper(nums, mid + 1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = this.countRange(nums, left, lo, hi);
        int rightCount = this.countRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    private int countRange(int[] nums, int left, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == left) {
                count++;
            }

        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
