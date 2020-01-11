public class LeetCode_50_0190 {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1.0;
        double current_product = x;
        for (long i = N; i > 0 ; i = i >> 1) {
            if ((i & 1) == 1) ans *= current_product;
            current_product *= current_product;
        }
        return ans;
    }
}
