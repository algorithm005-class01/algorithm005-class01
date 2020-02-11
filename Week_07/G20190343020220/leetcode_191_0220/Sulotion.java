package Week_07.G20190343020220.leetcode_191_0220;

/**
 * @author Darcy
 * @date 2020-02-08 10:04
 */
public class Sulotion {

    public int hammingWeight(int n) {

        int count = 0;
        int temp = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & temp) != 0) {
                count++;
            }
            temp = temp << 1;
        }
        return count;

    }
}
