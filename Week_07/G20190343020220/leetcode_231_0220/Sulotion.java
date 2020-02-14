package Week_07.G20190343020220.leetcode_231_0220;

/**
 * @author Darcy
 * @date 2020-02-08 10:12
 */
public class Sulotion {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n * (n - 1) == 0);
    }
}
