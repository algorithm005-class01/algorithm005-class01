package Week_07.G20190343020220.leetcode_338_0220;

/**
 * @author Darcy
 * @date 2020-02-08 10:35
 */
public class Sulotion {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);

        }
        return ans;
    }
}
