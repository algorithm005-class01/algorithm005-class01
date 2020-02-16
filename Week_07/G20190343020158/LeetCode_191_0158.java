public class Solution {
    // you need to treat n as an unsigned value

    /**
     * 思路：n & (n - 1) 会去掉n的二进制数的最低位的1
     * 当n为0时，则没有1了
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}