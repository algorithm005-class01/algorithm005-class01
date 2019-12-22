/**
 *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

    说明：本题中，我们将空字符串定义为有效的回文串。

    示例 1:

    输入: "A man, a plan, a canal: Panama"
    输出: true
    示例 2:

    输入: "race a car"
    输出: false

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-palindrome
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

class Solution
{
public:
    bool isPalindrome(string s)
    {
        int size = s.length();
        if (size == 0 || size == 1)
            return true;
        // 确定中心点, 可以合并,为了易读性,暂时不合并
        int i = 0, j = size - 1;
        // 标记有一个字母相同
        // bool hasOneSame = false;

        //双指针遍历, 注意有i==j的情况
        while (i <= j)
        {
            if (!validChar(s.at(i)))
            {
                i++;
                continue;
            }

            if (!validChar(s.at(j)))
            {
                j--;
                continue;
            }
            if (!sameChar(s.at(i), s.at(j)))
                return false;
            // hasOneSame = true;
            i++;
            j--;
        }
        return true;
    }

    // 第48～57号为0～9十个阿拉伯数字；65～90号为26个大写英文字母，97～122号为26个小写英文字母
    bool validChar(char c)
    {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    // 判断两个字符是否相等 , 不区分大小写
    bool sameChar(char i, char j)
    {
        // 其中一个为数字
        bool isNumber = (i >= 48 && i <= 57) || (j >= 48 && j <= 57);
        if (isNumber && i != j)
        {
            return false;
        }
        else if (i == j)
        {
            return true;
        }
        else if (i > j)
        {
            return (i - 32) == j;
        }
        return (j - 32) == i;
    }
};

class Solution2
{
public:
    bool isPalindrome(string s)
    {
        int size = s.length();
        if (size <= 1)
            return true;
        // 确定中心点, 可以合并,为了易读性,暂时不合并
        int i = 0, j = size - 1;
        // 标记有一个字母相同
        // bool hasOneSame = false;

        //双指针遍历, 注意有i==j的情况
        while (i <= j)
        {
            if (!isalnum(s.at(i)))
            {
                i++;
                continue;
            }

            if (!isalnum(s.at(j)))
            {
                j--;
                continue;
            }
            if (!sameChar(s.at(i), s.at(j)))
                return false;
            // hasOneSame = true;
            i++;
            j--;
        }
        return true;
    };

    // 判断两个字符是否相等 , 不区分大小写
    bool sameChar(char i, char j)
    {
        // 其中一个为数字
        if (i >= 'A' && i <= 'Z')
        {
            i += 32;
        }
        if (j >= 'A' && j <= 'Z')
        {
            j += 32;
        }
        return i == j;
    }
};

class Solution3
{
public:
    bool isPalindrome(string s)
    {
        int size = s.length();
        if (size <= 1)
            return true;
        // 确定中心点, 可以合并,为了易读性,暂时不合并
        int i = 0, j = size - 1;
        //双指针遍历, 注意有i==j的情况
        while (i < j)
        {
            while (i < j && !isalnum(s.at(i)))
            {
                i++;
            }
            while (i < j && !isalnum(s.at(j)))
            {
                j--;
            }
            if (tolower(s.at(i++)) != tolower(s.at(j--)))
                return false;
        }
        return true;
    };
};

class Solution4
{
public:
    bool isPalindrome(string s)
    {
        int size = s.length();
        if (size <= 1)
            return true;
        // 确定中心点, 可以合并,为了易读性,暂时不合并
        int i = 0, j = size - 1;
        //双指针遍历, 注意有i==j的情况
        while (i < j)
        {
            while (i < j && !isalnum(s.at(i)))
            {
                i++;
            }
            while (i < j && !isalnum(s.at(j)))
            {
                j--;
            }
            if (tolower(s.at(i++)) != tolower(s.at(j--)))
                return false;
        }
        return true;
    };
};

int main(int argc, char **argv)
{
    vector<string> arrs;
    arrs.push_back("");
    arrs.push_back("A man, a plan, a canal: Panama");
    arrs.push_back("race a car");
    arrs.push_back("ab,a");
    arrs.push_back(",,b,");
    arrs.push_back(",,,"); // 注意这个算是正确的
    for (auto s : arrs)
    {
        cout << s << " isPalindrome: " << Solution2().isPalindrome(s) << endl;
    }
    return -1;
}

/**
 * 
 * 这里先想到的是基于对称性,前后两边进行比较, 判断是否相等, 这种对称性的 我先想到的是 双指针法, 因为有很多题数组,链表等都是类似这种解法. 
 * 确定没有想到 对象性与最近相关性的 可以使用栈的解法处理
 * 奇怪的是 Solution3 的解法为什么并没有特别快
 * 
 * 
 * 
 * 
 * 
 * 
*/