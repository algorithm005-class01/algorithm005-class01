package G20190343020018;

/**
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author: wangbo4
 * @create: 2019-12-11 13:48
 **/
public class LeetCode_11_0018 {
    public static void main(String[] args) {

        //test case
        int[] arrays = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(arrays));

        System.out.println(maxArea_2(arrays));

    }

    /**
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 思路：两个角标 i j。一个从头开始，一个从末尾开始。
     * 因为：从最两边开始，底边是由长变短。当底边一样时，面临一个选择：i+1 和 j-1，所以 这时候比较 i 和 j，谁小谁进1。
     * @return
     */
    public static int maxArea_2(int[] array) {
        int max = -1;
        for (int i = 0, j = array.length - 1; i < j; ) {
            int area = (j - i) * Math.min(array[i], array[j]);
            max = Math.max(max, area);
            if (array[i] < array[j]) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
        return max;
    }
}
