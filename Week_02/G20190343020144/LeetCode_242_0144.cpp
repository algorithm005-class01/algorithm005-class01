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
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

/**
 * 字母异位词 的必要条件 
 * 1. 等长 (可以减少很多处理)
 * 2. 排序后 一定相等
 * 
 * 算法复杂度 排序 O(nlogn), 字符串判等最多 O(n) 也就是 平均时间复杂度 O(nlogn)
*/
class SolutionSort
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length())
            return false;

        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        // 字符串判断相等 不需要遍历字符了
        return s == t;
    }
};

/**
 * hash法
 * 类似与匹配符号一样, 出栈入栈, 等两个字符串中的字符相互抵消后, 所有字符的value 都为 0 则说明 是
 * 
 * 那么如何遍历所有字符的 value 是一个问题
 * 
*/
class SolutionHash
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length())
            return false;
        unordered_map<char, int> hash;
        for (char c : s)
            {
                ++hash[c];
            }
        for (char c : t){
            --hash[c];
        }
        for (auto iter: hash) {
            if (iter.second != 0) return false;
        }
        return true;
    };
};

/**
 * 优化 hash 表中某一个字符不符合后 旧提前判断失败的技巧
 * 
*/
class SolutionHash2
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length())
            return false;
        unordered_map<char, int> hash;
        for (char c : s)
            ++hash[c];
        // 优化 在这里可以提前结束判断
        for (char c : t) {
            if (--hash[c] < 0)return false;
        }
        // 遍历方式
        for (auto &iter: hash) {
            if (iter.second != 0) return false;
        }
        return true;
    }
};

/**
 * 该解法仅仅是 优化了 hash表的内存分配, 没有太大工程意义, 扩展性不强
 * 
*/
class SolutionHash3
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length())
            return false;
        // 因为原题目是a-z 的26字母 小写字母
        int hash[26] = {0};// 注意这里一定要赋初值, 否则会出现问题
        for (int i = 0 ; i < s.size(); i++)
            ++hash[s[i] - 'a'];
        // 优化 在这里可以提前结束判断, 这里可以直接遍历字符串区索引字符, 不需要直接生成字符
        for (int i = 0 ; i < t.size(); i++) {
            if (--hash[t[i] - 'a'] < 0)return false;
        }
        // 遍历方式
        for (int i = 0; i < 26 ; i++) {
            if (hash[i] != 0) return false;
        }
        return true;
    }
};

/// 还有一种 素数法, 就是 将 字母对应一个素数, 计算所有字母的乘积, 一致则说明是 true; 其实这本身就是一种 hash 的计算方式
int main()
{
    cout << SolutionHash().isAnagram("fds", "sdf") << endl;
    cout << SolutionHash().isAnagram("a", "b") << endl;
    cout << SolutionHash().isAnagram("dfdgdg", "sdf") << endl;
    return -1;
}