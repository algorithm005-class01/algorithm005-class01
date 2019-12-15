package TrappingRainWater042;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author yx101 (David Qu)
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * ^
 * |
 * 3 |                       +--+
 * |                       |  |
 * 2 |          +--+xxxxxxxxx|  +--+xx+--+
 * |          |  |xxxxxxxxx|  |  |xx|  |
 * 1 |   +--+xxx|  +--+xxx+--+  |  +--+  +--+
 * |   |  |xxx|  |  |xxx|  |  |  |  |  |  |
 * 0 +---+--+---+--+--+---+--+--+--+--+--+--+----->
 * 0  1   0  2  1   0  1  3  2  1  2  1
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;

        //找到最大的值/位置
        int maxHigh = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxHigh) {
                maxHigh = height[i];
                maxIdx = i;
            }
        }

        //从左到最大位置
        int prevHigh = 0;
        for (int i = 0; i < maxIdx; i++) {
            if (height[i] > prevHigh) {
                prevHigh = height[i];
            }
            result += (prevHigh - height[i]);
        }

        //从右边到最大位置
        prevHigh = 0;
        for (int i = n - 1; i > maxIdx; i--) {
            if (height[i] > prevHigh) {
                prevHigh = height[i];
            }
            result += (prevHigh - height[i]);
        }

        return result;
    }
}
