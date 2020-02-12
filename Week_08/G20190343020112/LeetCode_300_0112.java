class Solution {
    public int lengthOfLIS(int[] nums) {
        // if (nums == null) return 0;
        // if (nums.length < 2) return nums.length;
        // int[] dp = new int[nums.length];
        // int max = dp[0] = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     int maxtmp = 0;
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] > nums[j]) {
        //             maxtmp = Math.max(maxtmp, dp[j]);
        //         }
        //     }
        //     dp[i] = maxtmp + 1;
        //     max = Math.max(max, dp[i]);
        // }

        // return max;

        int[] dp = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(dp, 0, len, nums[i]);
            if (index < 0) index = -(index + 1);
            dp[index] = nums[i];
            if (index == len) len++;
        }
        return len;
    }
}
