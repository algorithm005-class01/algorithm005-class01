/**
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    /**
     * 按照爬升来算, 只买相隔两天赚钱的 这样就是最大化利益, 从来没有赔过钱
     * 但是这种方法不太使用
     * 
贪心算法和“动态规划”、“回溯搜索”算法一样，完成一件事情，是分步决策的；
“贪心算法”在每一步总是做出在当前看来最好的选择，我是这样理解“最好”这两个字的意思：
“最好”的意思往往根据题目而来，可能是“最小”，也可能是“最大”；

贪心算法和动态规划相比，它既不看前面（也就是说它不需要从前面的状态转移过来），也不看后面（无后效性，后面的选择不会对前面的选择有影响），因此贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的。

这道题“贪心”的地方在于，对于“今天的股价 - 昨天的股价”，得到的结果有 3 种可能：（1）正数（2）0（3）负数，我们只加正数。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */
    int maxProfit(vector<int> &prices)
    {
        if (prices.size() == 0)
            return 0;
        int profit = 0;
        for (size_t i = 1; i < prices.size(); i++)
        {
            if (prices[i] - prices[i - 1] > 0)
            {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    int maxProfitVP(vector<int> &prices)
    {
        if (prices.size() == 0)
            return 0;
        int profit = 0;
        int valley = 0;
        int peek = 0;
        int l = 0;
        while (l < prices.size() - 1)
        {
            // 获取valley
            while (l < prices.size() - 1 && prices[l] >= prices[l + 1])
                l++;
            valley = prices[l];
            while (l < prices.size() - 1 && prices[l] <= prices[l + 1])
                l++;
            // 获取peek
            peek = prices[l];
            profit += peek - valley;
        }
        return profit;
    }

    /**
    第一维 i 表示索引为 i 的那一天（具有前缀性质，即考虑了之前天数的收益）能获得的最大利润；
    第二维 j 表示索引为 i 的那一天我是持有股票，还是持有现金，这里 0 表示持有现金（cash），1 表示持有股票（stock） 

    注意 这里计算的时候 持有股票, 直接可以卖或者买股票, 不需要关心差价.  
    不过这里我注意到的是, 收益有负值 !!!! 真实场景不可能这样计算, 应该有说明本金金额是多少才行

    作者：liweiwei1419
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */
    int maxProfitDP(vector<int> &prices)
    {
        if (prices.size() < 2)
            return 0;
        /*
            dp[i + 1][0]
                        dp[i][0]
                        dp[i][1] + prices[i+1] 当天(i+1)买了股票
            dp[i + 1][1]
                    dp[i][1]
                    dp[i][0] - prices[i+1] 买当天(i+1)的股票 
        */
        int dp[prices.size()][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (size_t i = 1; i < prices.size(); i++)
        {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.size() - 1][0];
    }
};

int main(int argc, char **argv)
{
    vector<vector<int>> arrs;
    arrs.push_back({1, 1, 1});
    arrs.push_back({9, 9, 9});
    arrs.push_back({9, 6, 9});
    arrs.push_back({9, 6, 1});
    arrs.push_back({0});
    for (auto arr : arrs)
    {
        int v = Solution().maxProfit(arr);
    }
    return -1;
}