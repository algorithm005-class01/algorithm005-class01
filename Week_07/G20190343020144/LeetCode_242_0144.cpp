/**
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length())
            return false;
        // 因为原题目是a-z 的26字母 小写字母
        int hash[26] = {0}; // 注意这里一定要赋初值, 否则会出现问题
        for (int i = 0; i < s.size(); i++)
            ++hash[s[i] - 'a'];
        // 优化 在这里可以提前结束判断, 这里可以直接遍历字符串区索引字符, 不需要直接生成字符
        for (int i = 0; i < t.size(); i++)
        {
            if (--hash[t[i] - 'a'] < 0)
                return false;
        }
        // 遍历方式
        for (int i = 0; i < 26; i++)
        {
            if (hash[i] != 0)
                return false;
        }
        return true;
    }
};