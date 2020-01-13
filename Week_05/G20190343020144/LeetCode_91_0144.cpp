/**
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

// 懵逼了有点: 推荐 查看解题方式 https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/

/**
 * 犯的错误 
 * 1. 没有手写举例 几个 case, 心算容易有问题
 * 2. ASCII 码认识有问题, '1' 直接当做了 1
 * 
 * 一定要回想走楼梯或者偷东西两个案例
*/
int numDecodings(string s)
{
    if (s[0] == '0')
        return 0;
    int pre = 1, curr = 1; //dp[-1] = dp[0] = 1 为什么呢, 这是因为更新了 pre
    for (int i = 1; i < s.size(); i++)
    {
        int tmp = curr;
        if (s[i] == '0')
            if (s[i - 1] == '1' || s[i - 1] == '2')
                curr = pre;
            else
                return 0;
        else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6'))
            curr = curr + pre;
        pre = tmp;
    }
    return curr;
}

/***
 *  推荐题解二 
 链接：https://leetcode-cn.com/problems/decode-ways/solution/jing-dian-di-tui-by-haozheyan97/

   迁移方程
  f(0) = 1
  f(i) = valid(lastOneSymbol) * f(i - 1) + valid(lastTwoSymbols) * f(i - 2)

 * 
 * 
*/

class Solution
{
public:
    int *dp;

    bool check(char h, char l)
    {
        int hh = h - '0', ll = l - '0';
        int val = hh * 10 + ll;

        return val >= 10 && val <= 26;
    }

    int numDecodings(string s)
    {
        int n = s.length();
        dp = (int *)malloc((n + 1) * sizeof(int));

        dp[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            dp[i] = 0;
            if (s[i - 1] > '0')
                dp[i] += dp[i - 1];
            if (i > 1 && check(s[i - 2], s[i - 1]))
                dp[i] += dp[i - 2];
        }

        return dp[n];
    }
};
