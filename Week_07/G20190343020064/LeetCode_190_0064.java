package G20190343020064;

/**
 * <p>
 * 颠倒二进制位
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-04 11:40 上午
 */
public class LeetCode_190_0064 {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                result += (1 << (31 - i));
            }
        }
        return result;
    }

}
