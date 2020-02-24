/**
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
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
        if (s.length() < 2)
            return s;
        // 查找边界 双指针
        int left = 0, right = 1;
        while (right < s.length())
        {
            if (right == s.length() - 1)
            {
                reverseWord(s, left, right);
                right++;
            }
            else if (s[right] == ' ')
            {
                reverseWord(s, left, right - 1);
                left = right + 1;
                right = left + 1;
            }
            else
            {
                right++;
            }
        }
        return s;
    }

    // 反转单词, 注意这里要传递引用才可以
    void reverseWord(string &s, int left, int right)
    {
        while (left < right)
        {
            swap(s[left++], s[right--]);
        }
    }
};