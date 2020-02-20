package week_07.commit;

// 191. 位1的个数
// https://leetcode-cn.com/problems/number-of-1-bits/
public class Solution_191_01 {

    public static int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }
}
