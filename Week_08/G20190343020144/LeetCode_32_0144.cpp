/**
 * 
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int longestValidParentheses(string s)
    {
        // 动态规划 定义状态, dp[i] 为 0..i的字符串 有效长度的值
        // 字符串问题, 常常用的技巧是 , 以最后字符来计算重复子问题
        if (s.size() <= 1)
            return 0;
        vector<int> dp(s.size() + 1, 0);
        dp[0] = 0;
        dp[1] = 0;
        int maxDP = 0;

        for (int i = 1; i < s.size(); ++i)
        {
            if (s[i] == ')' && s[i - 1] == '(')
            {
                dp[i] = i >= 2 ? (dp[i - 2] + 2) : 2;
            }
            else if (s[i] == ')' && s[i - 1] == ')' && i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(')
            {
                // 找存在可能是有效括号的情况, 不存在的话 就当它那边是 0
                // 与它匹配的位置 形如右侧两部分的样子 [ leftPart dp[?] 的值  ] + '(' + [rightPart dp[?]] + ')'
                int leftPart = (i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0;
                dp[i] = dp[i - 1] + 2 + leftPart;
            }
            else
            {
                dp[i] = 0;
            }
            maxDP = max(maxDP, dp[i]);
        }
        return maxDP;
    }
};