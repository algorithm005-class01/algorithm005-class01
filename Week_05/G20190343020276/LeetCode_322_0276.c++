class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // 方法一：BFS
        // .
        // .
        // .
        // 方法二：dp
        // 步骤一：找子问题
        // 步骤二：定义状态
        // 步骤三：状态转移方程 f(n) = min(f(n-k),for k in coins) + 1
        // f(n)表示凑成总金额n所需要的最少硬币个数 k表示给定的硬币面额
        vector<int> dp(amount+1,amount + 1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.size();j++)
            {
                if(i>=coins[j])
                {
                    dp[i] = min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount? -1:dp[amount];
    }
};