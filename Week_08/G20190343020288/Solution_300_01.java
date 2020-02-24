package week_08.commit;

import java.util.Arrays;

// 300. 最长上升子序列
// https://leetcode-cn.com/problems/longest-increasing-subsequence/
public class Solution_300_01 {

    public class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;

            for (int x : nums) {
                int i = Arrays.binarySearch(dp, 0, len, x);
                if (i < 0) i = -(i + 1);
                dp[i] = x;
                if (i == len) len++;
            }

            return len;
        }
    }
}
