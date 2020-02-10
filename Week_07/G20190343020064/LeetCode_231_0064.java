package G20190343020064;

/**
 * <p>
 * 2的幂
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-04 11:39 上午
 */
public class LeetCode_231_0064 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
