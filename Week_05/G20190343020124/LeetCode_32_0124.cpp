    /*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.78%)
 * Likes:    457
 * Dislikes: 0
 * Total Accepted:    33.9K
 * Total Submissions: 116.4K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int longestValidParentheses(string s) {
        if (s.size() <= 1) return 0;
        int len = 0;
        stack<int> st;
        st.push(-1);
        for (int i = 0; i<s.size(); i++) {
            if (s[i] == '(') {
                st.push(i);
            } else {
                if (st.empty() || st.top() == -1) st.push(i);
                else {
                    char top = s[st.top()];
                    if (top == '(') {
                        st.pop();
                        len = max(i - st.top(), len);
                    } else {
                        st.push(i);
                    } 
                }
                
            }
        }
        return len;
    }
};
// @lc code=end

