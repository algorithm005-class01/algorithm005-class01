package G20190343020064;

/**
 * <p>
 * 位1的个数
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-03 10:02 下午
 */
public class LeetCode_191_0064 {


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
