//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


package leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            //分治(子问题)：maxSum(i) = Max(maxSum(i-1),0) + a[i]
            //状态数组定义
            //dp方程 f[i] = Max(f[i-1], 0) + a[i] 然后找出f[i]最大值。
            int[] dp = new int[nums.length];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= nums.length - 1; i++) {
                dp[i] = Math.max(0, dp[i - 1]) + nums[i];
                max = Math.max(max, dp[i]);
            }
            return max;

        }

        private int dp(int i, int[] nums) {
            if (i == 0) {
                return nums[i];
            }
            int max = Math.max(dp(i - 1, nums), 0) + nums[i];
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}