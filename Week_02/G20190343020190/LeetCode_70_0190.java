import java.util.HashMap;
import java.util.Map;

public class LeetCode_70_0190 {
    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        else if (map.containsKey(n)){
            return map.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
            return result;
        }
    }
}
