package G20190343020064;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 两数之和
 * </p>
 *
 * @author mingke.yan  2019-12-20 2:56 下午
 */
public class LeetCode_1_0064_02 {

    public int[] twoSum(int[] nums, int target) {
        //===============================================================================
        //  <值,对应下标>
        //===============================================================================
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            Integer index = map.get(expect);
            if (index == null) {
                map.put(nums[i],i);
            } else {
                return new int[] {index,i};
            }
        }
        return new int[0];
    }

}
