//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            _generate(0, 0, 2, "");
            return list;
        }

        private void _generate(int left, int right, int n, String s) {
            //terminator
            if (left == n && right == n) {
                list.add(s);
                return;
            }
            //process

            //drill down
            if (left < n) _generate(left + 1, right, n, s + "(");
            if (left > right) _generate(left, right + 1, n, s + ")");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}