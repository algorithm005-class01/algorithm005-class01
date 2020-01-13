var maxSubArray = function(nums) {
    if (!nums) {
        return 0;
    }
    
    let result = 0;
    let dp = [...nums];
    
    for (let i = 1; i < dp.length; i++) {
        dp[i] = Math.max((dp[i - 1] + dp[i]), dp[i]);
    }
    
    // Note: return the maximum element in the dp array
    // Not the last one.
    return Math.max(...dp);
};