/**
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/
#include <iostream>
#include <vector>
using namespace std;

// 动态规划求解 , 类似与跳台阶

/// 推荐答案: https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/

class Solution
{
public:
    /// 动态规划 求解过程, BF -> 递归 -> 无备忘录的 自下而上 动态规划-> 有备忘录的自下而上 动态规划
    int coinChange(vector<int> &coins, int amount)
    {
        vector<int> dp(amount + 1, amount + 1);
        dp[0] = 0;

        for (int coin : coins)
        {
            for (int i = 1; i <= amount; i++)
            {
                if (coin <= i)
                    dp[i] = min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    int coinChangeBF(vector<int> &coins, int amount)
    {
        if (amount == 0)
            return 0;
        int ans = INT_MAX;
        for (int coin : coins)
        {
            // 金额不可达
            if (amount - coin < 0)
                continue;
            int subProb = coinChange(coins, amount - coin);
            // 子问题无解
            if (subProb == -1)
                continue;
            ans = min(ans, subProb + 1);
        }
        return ans == INT_MAX ? -1 : ans;
    }

    int coinChangeMemo(vector<int> &coins, int amount)
    {
        // 备忘录初始化为 -2
        vector<int> memo(amount + 1, -2);
        return helper(coins, amount, memo);
    }

    int helper(vector<int> &coins, int amount, vector<int> &memo)
    {
        if (amount == 0)
            return 0;
        if (memo[amount] != -2)
            return memo[amount];
        int ans = INT_MAX;
        for (int coin : coins)
        {
            // 金额不可达
            if (amount - coin < 0)
                continue;
            int subProb = helper(coins, amount - coin, memo);
            // 子问题无解
            if (subProb == -1)
                continue;
            ans = min(ans, subProb + 1);
        }
        // 记录本轮答案
        memo[amount] = (ans == INT_MAX) ? -1 : ans;
        return memo[amount];
    }
};

int main(int argc, char **argv)
{
    vector<int> ans;
    int v = Solution().coinChange(ans, 10);
    return -1;
}