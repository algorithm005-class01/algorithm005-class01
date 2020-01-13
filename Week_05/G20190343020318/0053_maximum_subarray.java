class Solution {
   /**
     * 状态转移方程：sum[i] = max{sum[i - 1] + a[i], a[i]} 
     * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
     * 时间复杂度：O(n)
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];  // base case
        int sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // sum[i] = max{sum[i - 1] + a[i], a[i]}
            sum = Math.max(sum + nums[i], nums[i]); 
            //  update maximum
            result = Math.max(result, sum);
        }
        return result;
    }
}


