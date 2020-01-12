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

解题2:

通过dp公式 a[i] = a[i - 1] + a[i - 2];  发现 i的值 只和 a-1和a-2相关

所以通过2个int值保存 a-1 和 a-2;
一次循环就可以得到结果

### https://leetcode-cn.com/problems/unique-paths/ 62. 不同路径

1. 分治. m*n的路径问题. f(m,n) = f(m-1,n)+f(m,n-1);
2. 状态空间  dp[m][n] 表示m*n的路径和.
3. 解决问题  dp[m][n] = dp[m-1][n]+ dp[m][n-1];


优化: 空间压缩

没弄太明白

### https://leetcode-cn.com/problems/unique-paths-ii/ 63. 不同路径 II

和不同路径1 是一个思路. 但是状态转移方程要添加条件限制. 当==1 的时候. 路径是0  否则才是dp[m][n] = dp[m-1][n]+ dp[m][n-1];

路径压缩也是一样的思路: 当[n] == 1 的时候. dp[n] = 0;

### https://leetcode-cn.com/problems/longest-common-subsequence/ 1143. 最长公共子序列

分治. 将text1和text2最长公共子序列的问题, 转换为text1[0-i]和text2[0-j]的最长公共子序列问题
  
状态空间 text1 长度m 和 text2 长度n 分别组成横坐标和竖坐标. 构成2唯数组 dp[][]  dp[i][j] = text1[0-i]和text[0-j]的最长公共子序列

解决问题 当text1[i-1] == text2[j-1] ? dp[i][j] = dp[i-1][j-1] +1 : dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);


### https://leetcode-cn.com/problems/triangle/ 120. 三角形最小路径和

分治: f(i,j) = Math.min(f(i+1, j+1), f(i+1,j))+ f(i,j);
状态空间: dp[i] i行的最小路径和
解决问题: dp[j] = Math.min(dp[j],dp[j+1])+ triangle[i][j]

### https://leetcode-cn.com/problems/longest-valid-parentheses/  32. 最长有效括号


1. DP

分治: 子问题 以)结尾的有效子串数量
状态空间: dp[i] 0-i串中 有效子串的个数
解决问题: 状态转移方程 
```java
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
```

2. 双指针法

使用left和right指针. 

1. 从0到s.length遍历. 遇见( left++ 遇见 ) right++ . 当left == right max = Math.max(max, 2*right). right >= left left = right =0;
2. 从s.length到0开始遍历, 遇见( left++ 遇见 ) right++ . 当left == right max = Math.max(max, 2*left). left >= right left = right =0;

max的值就是最大的.


### https://leetcode-cn.com/problems/edit-distance/ 72. 编辑距离

将字符串s1改写成s2. 需要的最少操作次数. 使用dp table表, 
状态空间: dp[i][j] 0-i的字符串 改成 0-j的串  需要的次数
解决问题: s1[i] == s2[j] dp[i][j] = dp[i-1][j-1]; 否则 Math.min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1 ;

