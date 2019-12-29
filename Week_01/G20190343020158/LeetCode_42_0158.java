class Solution {
    public int trap(int[] height) {

        /**
         * 思考：此方法其实是按列求的升级，正常按列求时，是遍历的时候，求遍历到的数据的左边界和右边界，这样是在遍历的for循环内有嵌套了一层循环，时间复杂度不好
         * 根据升维的想法，空间换时间，提前将每个位置的左右边界分别用数组存起来
         *
         * 总体思路为：取左右边界较小的那个边，只有当较小的边大于当前的位置，才能储存雨水，此时当前位置能储存的量为，最小边减去当前位置
         *
         */
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
         maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
         maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1;i < height.length - 1; i++) {
         int min = Math.min(maxRight[i], maxLeft[i]);
         if (height[i] < min) {
             sum += min - height[i];
         }
        }
        return sum;

    }