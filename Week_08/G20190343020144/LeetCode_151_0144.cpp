/**
给定一个字符串，逐个翻转字符串中的每个单词。

 

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

进阶：

请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution
{
public:
    string reverseWords(string s)
    {
        if (s.empty())
            return s;
        int l = s.length() - 1;
        // 1. reverse all
        reverseStr(s, 0, l);

        // 2. reverse word
        int pre = 0;
        for (int i = 0; i <= l; i++)
        {
            if (s[pre] == ' ')
            {
                pre++;
            }
            else if (s[i] == ' ')
            {
                reverseStr(s, pre, i - 1);
                pre = i + 1;
            }
            else if (i == l)
            {
                reverseStr(s, pre, i);
            }
        }
        // 3. trim extra empty
        int begin = 0;
        while (begin <= l)
        {
            if (s[begin] != ' ')
            {
                break;
            }
            begin++;
        }

        int end = l;
        while (end >= 0)
        {
            if (s[end] != ' ')
            {
                break;
            }
            end--;
        }

        pre = begin;
        string ans = "";
        bool firstAdd = false;
        for (int i = begin; i <= end; i++)
        {
            if (s[pre] == ' ')
            {
                pre++;
            }
            else if (s[i] == ' ')
            {
                if (!firstAdd)
                {
                    firstAdd = true;
                }
                else
                {
                    ans.append(" ");
                }
                ans.append(s.substr(pre, i - pre));
                pre = i + 1;
            }
            else if (i == end)
            {
                if (!firstAdd)
                {
                    firstAdd = true;
                }
                else
                {
                    ans.append(" ");
                }
                ans.append(s.substr(pre, i - pre + 1));
            }
        }
        return ans;
    }

    void reverseStr(string &s, int lo, int hi)
    {
        while (lo < hi)
        {
            s[lo] = s[lo] ^ s[hi];
            s[hi] = s[lo] ^ s[hi];
            s[lo] = s[lo] ^ s[hi];
            lo++;
            hi--;
        }
    }
};