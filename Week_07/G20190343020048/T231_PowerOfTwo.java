package main.leetcode_solutions.bit_operation;

/**
 * @author wenzhuang
 * @date 2020/2/9 8:21 PM
 */
public class T231_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n >= 1 && (n & (n - 1)) == 0;
    }
}
