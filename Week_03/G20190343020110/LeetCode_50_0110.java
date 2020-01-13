/**
 * @Author huangxiong
 * @Date 2019/12/19
 * @Description
 **/
public class LeetCode_50_0110 {
    /**
     * 解法：1.分治
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }
}
