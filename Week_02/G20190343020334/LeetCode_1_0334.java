package Week_02.G20190343020334;

import java.util.HashMap;
import java.util.Map;


/**
 * @author GaoK
 * @date 2019/12/22
 */
public class LeetCode_1_0334 {
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

}
