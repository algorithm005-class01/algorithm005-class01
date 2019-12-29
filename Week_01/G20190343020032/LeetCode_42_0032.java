class Solution {
    public int trap(int[] height) {
        // 左边界
        int leftMax = 0;
        // 右边界
        int rightMax = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = height.length - 1;
        int sum = 0;
        // 左指针 < 右指针
        while (left < right) {
            // 左边的柱子 < 右边的柱子,中间可能有最高(分界)的柱子
            if (height[left] < height[right]) {
                // 发现更高柱子 需要修改左边界
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                // 左边界减去当前高度即为面积
                else {
                    sum = sum + (leftMax - height[left]);
                }
                left++;
            }
            // 右边同理
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum = sum + (rightMax - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}