package G20190343020064;

/**
 * <p>
 * 跳跃游戏 II
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-28 12:31 下午
 */
public class LeetCode_45_0064 {


    /**
     * 每次去当前位置能到达的最远距离，并更新，即考虑了该位置走所有位置的情况
     * 会存在 maxIndex > nums.lenth - 1 ，但是maxIndex包括 到达 nums.lenth - 1 的情况
     * 所以 step 为 到达 i 的最短步数
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int maxIndex = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录当前位置能到达的最远距离
            maxIndex = Math.max(maxIndex, nums[i] + i);
            // 当该index 为记录的最远位置时；则更新最远位置，步数 + 1
            if (i == end) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }


}
