class Solution {
    public int longestValidParentheses(String s) {
        int count = 0, res = 0, cur = 0;
        // 从左往右遍历一遍，遇到‘（’，count+1
        // 遇见')'，count-1
        // 如果count==0,说明目前遍历过的这个字串是有效的
        // 如果count<0,说明遍历的这段是无效的，重置count的值,下个字符重新开始
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count > 0) {
                cur++;
            }else if (count == 0) {
                res = Math.max(res, ++cur);
            } else {
                cur = 0;
                count = 0;
            }
        }
        count=0;
        cur = 0;
        // 从右往左遍历一遍，因为从左往右，无法计算((()，左括号多的情况，因为遇不count==0的情况。
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') count++;
            else count--;
            if (count > 0) {
                cur++;
            }else if (count == 0) {
                res = Math.max(res, ++cur);
            } else {
                cur = 0;
                count = 0;
            }
        }
        return res;
    }
}