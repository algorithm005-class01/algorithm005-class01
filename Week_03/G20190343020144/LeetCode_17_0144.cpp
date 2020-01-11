/**
 * 
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;

/*
1. 回溯
2. dfs (状态树的多种遍历方法)


c++语法: 

  字符串语法
  path.push_back(chs[i]);
  path.pop_back();
**/
class SolutionBacktrack
{
public:
    vector<string> letterCombinations(string digits)
    {
        if (digits.size() == 0)
            return {};
        map<char, vector<char>> m;
        m['2'] = {'a', 'b', 'c'};
        m['3'] = {'d', 'e', 'f'};
        m['4'] = {'g', 'h', 'i'};
        m['5'] = {'j', 'k', 'l'};
        m['6'] = {'m', 'n', 'o'};
        m['7'] = {'p', 'q', 'r', 's'};
        m['8'] = {'t', 'u', 'v'};
        m['9'] = {'w', 'x', 'y', 'z'};

        vector<string> ans;
        string path;
        _helper(digits, m, 0, path, ans);
        return ans;
    }

    void _helper(string &digits, map<char, vector<char>> &m, int level, string &path, vector<string> &ans)
    {
        // terminator
        if (digits.size() == level)
        {
            ans.push_back(path);
            return;
        }

        char c = digits[level];
        vector<char> chs = m[c];
        // process
        for (int i = 0; i < chs.size(); i++)
        {
            // 状态树
            path.push_back(chs[i]);
            _helper(digits, m, level + 1, path, ans);
            // reset
            path.pop_back();
        }
    }
};

#include <stack>

/**
 * 最开始我想 用stack模拟 递归调用, 暂时没有思路 
 * 先用递归吧, 其实上面的回溯和dfs基本一样, 代码就不写了
 * 
*/
