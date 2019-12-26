package G20190343020064;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 * 多数元素
 * </p>
 *
 * @author mingke.yan@hand-china.com 2019-12-26 3:50 下午
 */
public class LeetCode_169_0064 {

    /**
     * 用hash表缓存并记录数字的次数
     * 当出现次数超过 length/2 则直接返回
     * 时间：O(n)
     * 空间: O(n)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap(16);
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                if ((value + 1) > nums.length / 2) {
                    return num;
                }
                map.put(num, value + 1);
            }
        }
        return -1;
    }

    /**
     * 先排序，然后直接取 length 下标的数字
     * 时间 O(nlogn)
     * 空间 O(1) 或 O(n)
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 投票法
     * 时间：O(n)
     * 空间: O(1)
     *
     * @return
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int target = 0;
        for (int num : nums) {
            if (count == 0) {
                target = num;
            }
            count += target == num ? 1 : -1;
        }
        return target;
    }

}
