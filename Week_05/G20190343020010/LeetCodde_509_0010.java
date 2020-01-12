package com.miui.testbyxzl;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodde_509_0010 {

    class Solution {
        public int fib(int N) {
            return sub(N, new int[10000]);
        }

        private int sub(int N, int[] sum) {
            if (N <= 1) {
                return N;
            }
            if (sum[N] == 0) {
                return sub(N - 1, sum) + sub(N - 2, sum);
            }

            return sum[N];
        }
    }
}
