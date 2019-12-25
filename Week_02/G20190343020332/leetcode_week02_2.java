public class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return _climb_Stairs(0, n, memo);
    }
    public int _climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = _climb_Stairs(i + 1, n, memo) + _climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}