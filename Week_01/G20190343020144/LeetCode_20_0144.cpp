/**
 * 题目描述 :
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-parentheses
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/
#include <vector>
#include <iostream>
#include <string>
#include <unordered_map>
#include <stack>

using namespace std;

class Solution
{
public:
    bool isValid(string s)
    {
        // 特例
        if (s.length() == 0)
            return true;
        // 对称的用例 才有可能为真
        if (s.length() % 2 != 0)
            return false;
        // 声明一个保存映射关系的map, 这里有个问题卡了我一下, key value 的关系弄反了, 早先用 pair<char, char>('{', '}'), 一直不对;后来才发现 取值的时候, key 是 '}' 而不是 '{'
        unordered_map<char, char> pairs;
        // pairs.insert(pair<char, char>('}', '{'));
        // pairs.insert(pair<char, char>(']', '['));
        pairs['}'] = '{';
        pairs[']'] = '[';
        pairs[')'] = '(';
        // pairs.insert(pair<char, char>(')', '('));
        // pairs.insert(make_pair<char, char>(')', '('));

        stack<char> stk;
        char c, top;
        unordered_map<char, char>::iterator itr;
        for (size_t i = 0; i < s.length(); i++)
        {
            c = s.at(i);
            if (c == '{' || c == '[' || c == '(')
            {
                stk.push(c);
            }
            else if (c == '}' || c == ']' || c == ')')
            {
                if (stk.empty())
                    return false;
                top = stk.top();
                itr = pairs.find(c);
                if (itr == pairs.end() || itr->second != top)
                    return false;
                stk.pop();
            }
            else
            {
                return false;
            }
        }

        return stk.empty();
    }
};

int main(int argc, char **argv)
{
    vector<string> arrs;
    arrs.push_back("");
    arrs.push_back("{[]}");
    arrs.push_back("{[()]}");
    arrs.push_back("{[([])]}");
    arrs.push_back("{[[()]]}");
    arrs.push_back("{[(])}");
    arrs.push_back("{[])}");
    for (auto s : arrs)
    {
        cout << s << " isValid: " << Solution().isValid(s) << endl;
    }
    return -1;
}