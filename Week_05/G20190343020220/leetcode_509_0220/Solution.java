package Week_05.G20190343020220.leetcode_509_0220;

/**
 * @author Darcy
 * @date 2020-01-09 18:46
 */
public class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}
