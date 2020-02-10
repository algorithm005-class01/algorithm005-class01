package main.leetcode_solutions.bit_operation;

/**
 * @author wenzhuang
 * @date 2020/2/9 8:26 PM
 */
public class T190_ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }
}
