/**
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
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

class SolutionDP
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
                // leftPart 计算优先级问题, dp[?] ?对应的索引边界问题, 边界的dp值问题
                int leftPart = (i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0;
                dp[i] = leftPart + dp[i - 1] + 2;
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

#include <stack>

class SolutionStack
{
public:
    int longestValidParentheses(string s)
    {
        // 遇到
        // 存储 可能不匹配括号的索引
        stack<int> stack;
        // 首先放入 -1, 相当与上一个不合格的字符的位置
        stack.push(-1);
        // ")()())"

        int maxLength = 0;
        int size = s.size();
        int index = 0;
        int c = NULL;
        while (index < size)
        {
            c = s.at[index];
            if (c == '(')
            {
                // 遇到 '(' 直接 push
                stack.push(index);
            }
            else if (c == ')')
            {
                // 遇到 ')' 先 pop 再说, 这时才能计算有效括号的长度
                stack.pop();
                if (stack.empty())
                {
                    // 如果是空的先 填充一个索引, 这样可以避免 ()() 的情况, 不被计算为长度 2 , 而是真正的长度 4
                    stack.push(index);
                }
                else
                {
                    // 否则计算长度
                    maxLength = max(maxLength, index - stack.top());
                }
            }
            else
                return 0;
            index++;
        }
        return maxLength;
    }
};
