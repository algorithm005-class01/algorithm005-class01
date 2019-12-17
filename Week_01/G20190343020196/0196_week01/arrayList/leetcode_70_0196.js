/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */

 //没思路时
 //1.暴力解决 或 分析出基本情况

 //找最近重复子问题
 //只有if else
 //for while; recursion 就是不断重复
/*  1：1
 2：2
 3:f(1) + f(2) 种走法 
 4:f(2) + f(3) 种走法
 */
// 得出 f(n) = f(n-1) + f(n-2) : Fibonacci

var climbStairs = function (n) {
    let memo = [];
    return climb(0, n, memo);
};

var climb = function (i, n, memo) {
    //1. 确定终止条件
    if (i > n) {
        return 0;
    }
    if (i == n) {
        return 1;
    }
    //4.程序跑通后， 剪枝优化， 就是加入调查表, 将已出的结果存起, 遇到相应的input，直接返回
    if (memo[i] > 0) {
        console.log("剪枝" + memo[i]);
        return memo[i];
    }
    //3.最小 子重复问题的代码, 基本就这里考虑不全, 多写几次,调试一下, 拆开验证
    memo[i] = climb(i + 1, n, memo) + climb(i + 2, n, memo);
    console.log(memo[i]);

    //2. 确定每次最终返回什么
    return memo[i];
}


// @lc code=end

climbStairs(6);