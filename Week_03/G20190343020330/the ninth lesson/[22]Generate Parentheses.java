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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    public void helper(List<String> res, String temp, int left, int right, int n) {
        if (temp.length() == n * 2) {
            res.add(temp);
            return;
        }

        if (left < n) {
            helper(res, temp + "(", left + 1, right, n);
        }
        if (right < left) {
            helper(res, temp + ")", left, right + 1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
