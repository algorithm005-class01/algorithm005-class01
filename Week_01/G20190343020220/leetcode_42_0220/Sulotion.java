package leetcode_42_0220;


/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

*/

/**
 * @author Darcy
 * @date 2019-12-12 17:26
 */
public class Sulotion {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int leftMax = 0, rightMax = 0, left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    res = res + leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    res = res + rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return res;

    }
}
