package week_01.commit;

// 接雨水
// https://leetcode-cn.com/problems/trapping-rain-water/
public class Solution_42 {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int maxleft = 0, maxright = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft) maxleft = height[left];
                else result += maxleft - height[left];
                left++;
            } else {
                if (height[right] >= maxright) maxright = height[right];
                else result += maxright - height[right];
                right--;
            }
        }
        return result;
    }
}
