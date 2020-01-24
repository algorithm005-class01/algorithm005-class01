package G20190343020064;

/**
 * <p>
 * 盛最多水的容器
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-24 2:38 下午
 */
public class LeetCode_11_0064 {

    public int maxArea(int[] height) {
        int max = 0;
        int j = height.length - 1;
        int i = 0;
        while (i < j) {
            max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }


}
