学习笔记

## 动态规格总结

第一步: 将问题分解为子问题. 分治思路
第二步: 猜测递归方程
第三步: 合并子问题的解
第四步: 递归 or 记忆化 or 自底向上的建立DP
第五步: 解决原始问题

1. 分治  找重复性
2. 定义状态空间
3. 解决问题

## leetcode刷题记录

### https://leetcode-cn.com/problems/fibonacci-number/ 509. 斐波那契数

1. 分治  f(i) = f(i-1) + f(i-2)
2. 状态空间 dp(i)  表示i的斐波那契数.
3. n的斐波那契数就是 dp(n)

### https://leetcode-cn.com/problems/unique-paths/ 62. 不同路径

1. 分治. m*n的路径问题. f(m,n) = f(m-1,n)+f(m,n-1);
2. 状态空间  dp[m][n] 表示m*n的路径和.
3. 解决问题  dp[m][n] = dp[m-1][n]+ dp[m][n-1];