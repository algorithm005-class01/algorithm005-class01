/*
 * @lc app=leetcode.cn id=17 lang=cpp
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.57%)
 * Likes:    524
 * Dislikes: 0
 * Total Accepted:    65.4K
 * Total Submissions: 126.3K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
public:
    vector<string> letterCombinations(string digits)
    {
        vector<string> res;
        if (digits.size() == 0)
            return res;
        letterDfs("", res, digits, 0);
        return res;
    }

    void letterDfs(string combine, vector<string> &res, string digits, int level)
    {
        if (level >= digits.size()){
            res.push_back(combine);
            return;
        }
        char letter = digits.at(level);
        string s = store[letter];
        for (char i : s)
        {
            combine.push_back(i);
            letterDfs(combine, res, digits, level + 1);
            combine.pop_back();
        }
    }

private:
    unordered_map<char, string> store = {
        {'2', "abc"},
        {'3', "def"},
        {'4', "ghi"},
        {'5', "jkl"},
        {'6', "mno"},
        {'7', "pqrs"},
        {'8', "tuv"},
        {'9', "wxyz"}};
};
// @lc code=end

