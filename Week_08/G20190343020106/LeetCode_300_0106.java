import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null){
            return 0;
        }
        if(nums.length<=1){
            return nums.length;
        }
        int[] dp=new int[nums.length+1];
        dp[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
              if(nums[j]<nums[i]){
                  dp[i]=Math.max(dp[i],dp[j]+1);
              }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}