package Week_07.G20190343020220.leetcode_190_0220;

/**
 * @author Darcy
 * @date 2020-02-08 10:16
 */
public class Sulotion {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n >> i;
            temp = temp & 1;
            temp = temp << (32 - i);
            result |= temp;
        }
        return result;
    }
}
