package main.leetcode_solutions.bit_operation;

/**
 * @author wenzhuang
 * @date 2020/2/9 8:43 PM
 */
public class T338_CountingBits {
    /**
     * 动态规划解法1
     * dp[i] = dp[i & (i - 1)] + 1
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++){
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    /**
     * 动态规划解法2
     * dp[i] = dp[i >> 1] + (i & 1)
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++){
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
