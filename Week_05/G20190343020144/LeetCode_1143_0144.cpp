/**
 * 
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

 

示例 1:

输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。
 

提示:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
输入的字符串只含有小写英文字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int longestCommonSubsequence(string text1, string text2)
    {
        int m = text1.size();
        int n = text2.size();
        if (m == 0 || n == 0)
            return 0;
        // 定义状态 , dp[t1][t2] 为 子问题 字符串 t1 与 t2 的最长公共子序列长度
        // 定义状态数组
        int dp[m + 1][n + 1];
        // for (int i = 0 ; i < m + 1; ++i) {
        //     for (int j = 0 ; j < n + 1; ++j) {
        //         dp[i][j] = 0;
        //     }
        // }

        // 之所以要用 m+1 / n+1 的长度 是为了应对 dp[-1] 的问题 , 从1开始就可以解决.

        // 测试用例 "abc"  "def", 这里有个问题是 说明 if (text1[i - 1] == text2[j - 1]) 判断要这样写, 只要这样, 起点 text1[0] 与 text2[0] 才能照顾到
        for (int i = 1; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
                if (text1[i - 1] == text2[j - 1])
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 定义迁移方程
        return dp[m][n];
    }
};