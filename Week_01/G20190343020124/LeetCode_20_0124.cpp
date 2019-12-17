/*
 * @lc app=leetcode.cn id=20 lang=cpp
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.14%)
 * Likes:    1248
 * Dislikes: 0
 * Total Accepted:    166.9K
 * Total Submissions: 415.2K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
#include <string>
#include <stack>
using namespace std;
class Solution {
public:
    bool isValid(string s) {
        if (s.length() == 0) return true;
        stack<char> theStack;
		for (int i = 0; i < s.length(); i++) {
			char c = s[i];
			switch (c) {
				case ')' : 
                    if (theStack.empty()) return false;
					if (theStack.top() == '(') theStack.pop(); else return false;
					break;
				case ']' :
                    if (theStack.empty()) return false;
					if (theStack.top() == '[') theStack.pop(); else return false;
					break; 
				case '}' :
                    if (theStack.empty()) return false;
					if (theStack.top() == '{') theStack.pop(); else return false;
					break;
				default : 
					theStack.push(c);
					break;
			}
		}
		
		if (theStack.empty()) return true;
		return false;
    }
};
// @lc code=end

