import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ju·Felix on 2019/12/22.
 */
public class LeetCode_1_0290 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] results = twoSum(nums, 26);
        System.out.println(Arrays.toString(results));
    }

    /**
     * 1. Two Sum [easy]
     * @param nums [2, 7, 11, 15]
     * @param target 26
     * @return [2, 3]
     */
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[] { map.get(need), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
