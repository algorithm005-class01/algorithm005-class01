package 队列;

import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List < String > generateParenthesis(int n) {

        //2*n层
        _generate(0, 0, n, "");
        return null;
    }

/*     private void _generate(int level, int max, String s) {
        //背出套路
        //terminator : 终止条件
        if (level >= max) { //大于最大层，跳出递归
            System.out.println(s);
            return;
        }

        //process : 处理当前层
        String s1 = s + "(";
        String s2 = s + ")";

        //drill down   :进入下一层 
        _generate(level + 1, max, s1);
        _generate(level + 1, max, s2);
        //reverse states : 清理当层状态
        //局部变量不需要手动清了
    } */


    //数学归纳，验证数据的合法性，filter the invalid s
    //left 随时加，只要不超标
    //right 左个数>右个数
    //left和right可用数为n
    private void _generate(int left, int right, int n, String s) {

        //terminator
        //左右都用完
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }

        //process current logic

        //drill down
        //left 随时加，只要不超标
        if(left < n)
            _generate(left + 1, right, n, s + "(");

        //right 左个数>右个数
        if(left > right)
            _generate(left, right + 1, n, s + ")");

        //reverse status

	}

	public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(3));
    }
    
}
// @lc code=end