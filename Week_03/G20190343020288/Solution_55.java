package week_03.commit;

// 55. 跳跃游戏
// https://leetcode-cn.com/problems/jump-game/
public class Solution_55 {
    public static boolean canJump(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(A[i] + i, max);
        }
        return true;
    }
}
