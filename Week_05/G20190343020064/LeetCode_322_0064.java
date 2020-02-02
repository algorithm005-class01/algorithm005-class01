package G20190343020064;

import java.util.HashMap;

/**
 * <p>
 * 零钱兑换
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-11 4:06 下午
 */
public class LeetCode_322_0064 {

    public int[] map;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        map = new int[amount];
        int result = recursive(coins, amount);
        return result == 0 ? -1 : result;
    }

    public int recursive(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (map[amount - 1] != 0) {
            return map[amount - 1];
        }
        int res;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            res = recursive(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        map[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return map[amount - 1];
    }

}
