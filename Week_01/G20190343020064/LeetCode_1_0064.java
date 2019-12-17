package G20190343020064;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 两数之和
 * </p>
 *
 * @author mingke  2019-12-12 2:39 下午
 */
public class LeetCode_1_0064 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(8);
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (map.get(expect) == null) {
                map.put(nums[i],i);
            } else {
                return new int[] {map.get(expect),i};
            }
        }
        return new int[0];
    }

}
