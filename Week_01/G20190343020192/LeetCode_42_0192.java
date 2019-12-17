// https://leetcode-cn.com/problems/trapping-rain-water/
public class LeetCode_42_0192 {

    /*
    1. 定义左右2个指针left、right
    2. 定义左右2个最大高度maxLeft、maxRight
    3. 从左到右搜索，每次搜索只会出现以下2种情况:
     - 3.1. 左边高度 <= 右边高度
     - 3.2. 左边高度 > 右边高度
    4. 第3步可以确定左边界或者右边界（高度低的一方）
    5. 根据确定的左右边界进一步移动指针：
     - 5.1. 如果是左边低，left指针向右移动，遇到比自己低的，说明可以存水
     - 5.2. 如果是右边低，right指针向左移动，遇到比自己低的，说明可以存水
    6. 在第5步中可以存水的时候，累加存水量（因为左右边界均已确定）
     */
    public int trap(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int maxleft = 0, maxright = 0;

        while (left <= right) {
            // 左边高度 <= 右边高度
            if (height[left] <= height[right]) {
                // 寻找最大的左边界值
                if (height[left] >= maxleft) {
                    maxleft = height[left];
                } else {
                    // 左边最大高度是maxleft；已定位左右边界，可以计算容量
                    water += maxleft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxright) {
                    maxright = height[right];
                } else {
                    water += maxright - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
