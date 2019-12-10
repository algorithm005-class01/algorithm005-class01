import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author huangxiong
 * @Date 2019/12/1
 * @Description two sum
 **/
public class Code_1 {
    //用hashmap,时间复杂度为O(n)
    public int[] twoSum(int[] nums, int target) {
        String s = new String();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

    //暴力求解,时间复杂度为O(n2)
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        double[] u = {0.8, 0.83333, 1.5, 1.5, 3.0};
        Arrays.sort(u);
        for (int i = 0; i < u.length; i++) {
            System.out.println(u[i]);
        }
    }
}
