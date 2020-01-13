package G20190343020064;

/**
 * <p>
 * 斐波那契数
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-06 10:36 下午
 */
public class LeetCode_509_0064 {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] nums = new int[N + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= N; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[N];
    }

}
