/*
 * @lc app=leetcode.cn id=509 lang=javascript
 *
 * [509] 斐波那契数
 */

 // 动态规划遵循一套固定的流程：递归的暴力解法 -> 带备忘录的递归解法 -> 非递归的动态规划解法
 // 1.但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。
// @lc code=start
/**
 * @param {number} N
 * @return {number}
 */
var fib = function(N) {
    let memo = [];
    return fib_memo(N, memo);
};

 function fib_memo(i, memo) {
    //1. 确定终止条件
    if (i == 0) {
        return 0;
    }
    if (i == 1) {
        return 1;
    }
    //4.程序跑通后， 剪枝优化， 就是加入调查表, 将已出的结果存起, 遇到相应的input，直接返回
    if (memo[i] > 0) {
        console.log("剪枝" + memo[i]);
        return memo[i];
    }
    //3.最小 子重复问题的代码, 基本就这里考虑不全, 多写几次,调试一下, 拆开验证
    memo[i] = fib_memo(i- 1, memo) + fib_memo(i - 2 , memo);
    console.log(memo[i]);

    //2. 确定每次最终返回什么
    return memo[i];
}

// @lc code=end

