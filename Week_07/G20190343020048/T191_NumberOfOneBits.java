package main.leetcode_solutions.bit_operation;

/**
 * @author wenzhuang
 * @date 2020/2/9 8:19 PM
 */
public class T191_NumberOfOneBits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n &= n - 1;
            count++;
        }
        return count;
    }
}
