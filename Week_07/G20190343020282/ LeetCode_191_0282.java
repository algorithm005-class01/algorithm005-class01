package com.demo.test.leetcode;

/**
 * TODO
 *编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 示例 1：

 输入：00000000000000000000000000001011
 输出：3
 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 示例 2：

 输入：00000000000000000000000010000000
 输出：1
 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。

 * @author houyujia
 * @since 2020/2/9
 */
public class num_1_bits_191 {
    public static void main(String[] args) {
        System.out.println(method1(00000000000000000000000000001011));
    }

    /**
     *
     * 循环32次
     * 每次通过1的二进制左移来检查
     * @param n
     * @return
     */
    public static int method1(int n) {
        int bit=0;
        int m=1;
        for (int i = 0; i < 32; i++) {
            if ((n&m)!=0){
                bit++;
            }
            m <<=1;
        }
        return bit;
    }

    /**
     * 将 n 和 n - 1 进行与运算 把 n 中最低位的 1变成 0
     * @param n
     * @return
     */
    public static int method2(int n) {
        int s = 0;
        while (n != 0) {
            s++;
            n &= (n - 1);
        }
        return s;
    }
}
