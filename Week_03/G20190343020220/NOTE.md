学习笔记

## leetcode刷题思路笔记

### https://leetcode-cn.com/problems/powx-n/ 50 Pow(x, n)

解题思路: 递归 分治

如果计算  2^10 = 2^5+2^5; 2^9 = 2^4+2^4+2^1;

由此可以将n次想成的O(n)复杂度变成O(logn);
