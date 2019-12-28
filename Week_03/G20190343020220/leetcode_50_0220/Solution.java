package Week_03.G20190343020220.leetcode_50_0220;


/*实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
*/

/**
 * @author Darcy
 * @date 2019-12-27 11:20
 */
public class Solution {

    public double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double sub = this.fastPow(x, n / 2);
        if (sub % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }
}
