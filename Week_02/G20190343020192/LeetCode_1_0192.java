import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_0192 {

    // 1. 两数之和 https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
    /*
    解题思路：
    1. nums[0] + nums[1] = target 可以转换为 nums[0] = target - nums[1]
    2. 循环时先判断target - nums[1]是否已经存在，如果存在说明有对应值，返回结果
    3. 如果没有，则保存nums[i]，i到map
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                answer[0] = i;
                answer[1] = map.get(target - nums[i]);
                return answer;
            }
            map.put(nums[i], i);
        }

        return answer;
    }
}
