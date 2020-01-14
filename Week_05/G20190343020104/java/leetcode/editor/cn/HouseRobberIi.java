//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.Arrays;

public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(_rob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    _rob(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private int _rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[dp.length - 1];

//        int pre = 0, cur = 0, tmp;
//        for (int num : nums) {
//            tmp = cur;
//            //dp[n+1]=max(dp[n],dp[n−1]+num)
//            //我们发现 dp[n] 只与 dp[n−1] 和 dp[n−2] 有关系，因此我们可以设两个变量 cur和 pre 交替记录，将空间复杂度降到 O(1)
//            cur = Math.max(pre + num, cur);
//            pre = tmp;
//        }
//        return cur;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}