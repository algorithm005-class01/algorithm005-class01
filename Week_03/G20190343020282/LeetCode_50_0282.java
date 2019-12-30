package com.demo.test.leetcode;

/**
 * TODO
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

     示例 1:

     输入: 2.00000, 10
     输出: 1024.00000

 说明:

     -100.0 < x < 100.0
     n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

 * @author houyujia
 * @since 2019/12/28
 */
public class powx_n50 {


    /**
     * 解法一： 暴力循环
     * 时间复杂度 O（n）
     * @param x
     * @param n
     * @return
     */
    public static double method1(double x,int n) {
        double re=1;
        if (n==0){
            return 1;
        }

        for (int i = 0; i < Math.abs(n); i++) {
            re=re*x;
        }
        if (n < 0){
            re=1/re;
        }

        return re;
    }

    /**
     * 解法二  分治  子问题（x^(n/2) * x^(n/2) ）
     * 时间复杂度 O（logn）
     * @param x
     * @param n
     * @return
     */
    private static double method2(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
           return 1/method2(x,-n);
        }
        //子问题 处理
        double half = method2(x, n/2);
        //结果汇总
        return n % 2 == 0? half * half:half * half * x;

    }

    public static void main(String[] args) {
        System.out.println(method2(1.000000, -2147483648));
    }



}
