/**
 * 
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/**
 * 回溯处理 
 * 关键是 明白复合条件的括号规则
 * 如何剪枝
 * 
*/
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string path = "(";
        generateParenthesis(n,1,path,ans);
        return ans;
    }

    void generateParenthesis(int n, int leftCount,string &path,vector<string> &ans) {
        int o_size = path.size();
        if (o_size == n * 2) {
            ans.push_back(path);
            return;
        }
        // 1. ( 最多 n 个
        // 2. ( 要 不小于 )
        // 3. 长度 等于 2 * n

        if (leftCount < n) {
            if (leftCount > (o_size - leftCount)) {
                 path += "(";
                generateParenthesis(n,leftCount + 1,path,ans);
                path.pop_back();
                
                path += ")";
                generateParenthesis(n,leftCount,path,ans);
                path.pop_back();
            } else {
                path += "(";
                generateParenthesis(n,leftCount + 1,path,ans);
                path.pop_back();
            }
        } else {
            path += ")";
            generateParenthesis(n,leftCount,path,ans);
            path.pop_back();
        }      
    }
};

// 动态规划
class SolutionDP {

};