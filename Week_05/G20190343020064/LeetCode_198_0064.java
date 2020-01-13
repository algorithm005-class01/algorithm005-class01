package G20190343020064;

/**
 * <p>
 * 打家劫舍
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-12 4:11 下午
 */
public class LeetCode_198_0064 {

    /**
     * 添加状体 对每个房子有取或不取两种状体 构建二维数组 。。
     * 这里需要注意  2,1,1,2 得情况，，不取中间 1,1
     * 递推公式
     * f[i][0] = f[i-1][1]
     * f[i][1] = max(f[i-1][0],f[i-2][0]) + f[i]
     * 这个题目出现最大值的地方，必定是最后一个必取或最后第二个必去
     * 所以 再这里只需要 返回最后一个必取或不取取最大值即可
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] map = new int[nums.length + 2][2];
        for (int i = 0; i < nums.length; i++) {
            map[i + 2][0] = map[i + 1][1];
            map[i + 2][1] = Math.max(map[i + 1][0], map[i][0]) + nums[i];
        }
        return Math.max(map[nums.length + 1][0], map[nums.length + 1][1]);
    }

    /**
     * 递推公式 f[i] = max(f[i-2],f[i-3]) + nums[i]
     * f[i] 为当前位置必取得情况下最大得值
     * 这个题目出现最大值的地方，必定是最后一个必取或最后第二个必去
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] map = new int[nums.length + 3];
        for (int i = 0; i < nums.length; i++) {
            map[i + 3] = Math.max(map[i + 1], map[i]) + nums[i];
        }
        return Math.max(map[map.length - 1], map[map.length - 2]);
    }

}
