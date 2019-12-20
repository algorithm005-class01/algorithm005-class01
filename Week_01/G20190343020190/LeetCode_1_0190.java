import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_0190 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int find = target - num;
            if (map.containsKey(find)) {
                return new int[]{map.get(find), i};
            } else {
                map.put(num, i);
            }
        }
        throw new RuntimeException();
    }
}
