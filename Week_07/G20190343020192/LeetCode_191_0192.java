public class LeetCode_191_0192 {
    // 191. 位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            // X & (X-1) 清零最低位的 1
            n &= n - 1;
            sum++;
        }
        return sum;
    }
}
