import java.util.HashMap;
import java.util.Map;

public class LeetCode_01_0190 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find)){
                return new int[]{map.get(find), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
