/**
 * 
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"
要求:

该字符串只包含小写的英文字母。
给定字符串的长度和 k 在[1, 10000]范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-string-ii
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
    string reverseStr(string s, int k)
    {
        int pre = 0;
        int hi = s.length() - 1;
        for (int i = 0; i <= hi; i++)
        {
            if (i == hi)
            {
                if ((i - pre + 1) < k)
                {
                    reverseStrRange(s, pre, i);
                }
                else
                {
                    reverseStrRange(s, pre, pre + k - 1);
                }
            }
            else if ((i - pre + 1) == 2 * k)
            {
                reverseStrRange(s, pre, pre + k - 1);
                pre = i + 1;
            }
        }
        return s;
    }

    void reverseStrRange(string &s, int lo, int hi)
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