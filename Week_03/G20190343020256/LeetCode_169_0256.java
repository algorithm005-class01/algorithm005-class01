package Week3;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_169_0256 {
    static public int majorityElement(int[] nums) {
        // map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > nums.length / 2) {
                return num;
            }
            map.put(num, count);
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 3, 4};
        majorityElement(nums);
    }
}
