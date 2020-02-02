学习笔记



# 动态规划 Dynamic Programming

**动规 = 分治+ 最优子结构**

动规 和 递归或分治

+ 区别： 看有无最优的子结构
+ 共性：找到重复子问题，递归
+ 差异性： 最优子结构、 中途可以淘汰次优解



简单的DP: 递归的查录表

复杂的DP:

1. 升维了
2. 取舍最优子结构



## 动态规划之子序列问题解题模板

一般来说，这类问题都是让你求一个**最长子序列**，因为最短子序列就是一个字符嘛，没啥可问的。一旦涉及到子序列和最值，那几乎可以肯定，**考察的是动态规划技巧，时间复杂度一般都是 O(n^2)**。

既然要用动态规划，那就要定义 dp 数组，找状态转移关系。我们说的两种思路模板，就是 dp 数组的定义思路。不同的问题可能需要不同的 dp 数组定义来解决。



### 例题：路径计算：

#### 解法1：分治

![image-20200106151910168](/Users/marslee/Library/Application Support/typora-user-images/image-20200106151910168.png)

#### 解法2： DP

![image-20200106151939674](/Users/marslee/Library/Application Support/typora-user-images/image-20200106151939674.png)

## 动态规划关键点

+ 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2],...)
+ 存储中间状态： opt[i]
+ 递推公式( 美其名曰: 状态转移方程或者 DP方程)
  + Fib : opt[i] = opt[n-1] + opt[n-2]
  + 二维路径：opt[i,j] = opt[i+1] [j] + opt[i] [j+1] (且判读a[i,j]是否空地)



作业：

![image-20200106155936730](/Users/marslee/Library/Application Support/typora-user-images/image-20200106155936730.png)

# 一、两种思路

**1、第一种思路模板是一个一维的 dp 数组**：

```java
int n = array.length;
int [] dp  = new int [n];

for(int i = 1; i < n; i++){
      for (int j = 0; j < i; j++) {
        dp[i] = 最值(dp[i], dp[j] + ...)
    }
}
```

**2、第二种思路模板是一个二维的 dp 数组**：

```java
int n = arr.length;
int[][] dp = new dp[n][n];

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (arr[i] == arr[j]) 
            dp[i][j] = dp[i][j] + ...
        else
            dp[i][j] = 最值(...)
    }
}
//2.1 涉及两个字符串/数组时（比如最长公共子序列），dp 数组的含义如下：
//在子数组 arr1[0..i] 和子数组 arr2[0..j] 中，我们要求的子序列（最长公共子序列）长度为 dp[i][j]。
//2.2 只涉及一个字符串/数组时（比如本文要讲的最长回文子序列），dp 数组的含义如下：
//在子数组 array[i..j] 中，我们要求的子序列（最长回文子序列）的长度为 dp[i][j]。
```

## 