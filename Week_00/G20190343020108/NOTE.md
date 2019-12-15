# 数据结构与算法总览

## 职业化训练：精通一个领域（算法）

### 1. Chunk it up 切碎知识点

知识脉络，形成一颗树，人脑不适合记忆孤立的知识点。（对照脑图，多次反复记忆）

#### 数据结构分类

##### 一维数据结构

**基础**：数组（Array），链表（Linked List）

**高级**：栈（Stack），队列（Queue），双端队列（Deque），集合（Set），映射（hash or map），etc.

##### 二维数据结构

**基础**：树（tree）和图（graph）

**高级**：二叉搜索树（binary search tree [red-black tree, AVL]），堆（heap），并查集（disjoint set），字典树（Trie），etc.

##### 特殊数据结构

位运算（Bitwise），布隆过滤器（Bloom Filter）

LRU Cache

#### 算法分类

##### 基本算法

branch: if - else, switch

Iteration: for, while loop

递归 Recursion：Divide and Conquer, backtrace.

##### 高级算法

搜索 Search：深度优先搜索 Depth first Search，广度优先搜索 Breadth first search，启发式搜索 A*， etc.

动态规划 Dynamic Programming

二分查找 Binary Search - 对于一个有序的序列，很快的查找到所需的结点

贪心 Greedy

排序 Sort

数学 Match

几何 Geometry

> 自己动手绘制脑图

### 2. Deliberate Practicing 刻意练习

最大的误区：只做一遍。

**刻意练习 - 需要不断地过遍数。** 带来基本功的提升。

**练习缺陷、弱点的地方。** （不舒服、不爽、枯燥 -- 跳出舒适区）

### 3. Feedback 反馈

##### 即时反馈

##### 主动型反馈

- 高手代码 （GitHub，LeetCode）

##### 被动型反馈

- 高手指点 （Code Review）

## 切题四件套（单个题目）

- Clarification - 确保理解题意

- Possible Solutions - 想所有可能的解法
  - 比较时间空间复杂度
  - 寻找最优解

- Coding (多写)
- Test Cases 列举测试样例 （注意一些边缘样例）

## 五遍刷题法（过遍数）

### 第一遍

- 5分钟：读题 + 思考（最多十到十五分钟）
- 若没有思路：直接看解法（多个解法，比较优劣）
- 背诵、默写好的算法（很重要，相当于理解记忆）

### 第二遍

马上自己写（相当于闭卷考试）-> LeetCode 提交

注意多解法，同时注意执行时间。

### 第三遍

过了一天之后，再重复做题。

不同解法的熟练程度 - 专项练习

### 第四遍

过了一周之后，回过来反复练习相同的题目。

### 第五遍

面试前一周 - 恢复性训练

## Big O Notation

- O(1) : Constant Compleixty 常数复杂度

- O(log^n^)：Logarithmic Complexity 对数复杂度

  ```js
  for (let i = 1; i < n; i = i * 2) {
    console.log(i);
  }
  ```

- O(n)：Linear Complexity 线性复杂度

- O(n^2)：N Square Complexity N 平方复杂度

- O(n^3)：N Cubic Complexity N 立方复杂度

- O(2^n)：Exponential Growth 指数复杂度

  ```js
  // 简单的递归操作的时间复杂度
  function fib(n) {
    if (n <= 2) return n;
    return fib(n - 1) + fib(n - 2);
  }
  ```

  **递归程序的时间复杂度是 O(k^n^）**

  - 递归状态树 - 成指数级递增
  - 有重复计算 - （可以加一个缓存来存储中间结果）

- O(n!)：Factorial 阶乘复杂度

> 注意：只看最高的时间复杂度，不考虑前面的系数
>
> - 需要了解自己代码的时间复杂度
> - 用最优的时间复杂度来实现

## 主定理 （Master Theorem）

**主定理**：

| 算法                                                 | Recurrence relationship     | Run time   |
| ---------------------------------------------------- | --------------------------- | ---------- |
| Binary search<br />二分查找（一维）                  | `T(n) = T(n/2) + O(1)`      | O(log n)   |
| Binary tree traversal<br />二叉树遍历                | `T(n) = 2T(n/2) + O(1)`     | O(n)       |
| Optimal sorted matrix search<br />有序的二维矩阵查找 | `T(n) = 2T(n/2) + O(log n)` | O(n)       |
| Merge sort<br />归并排序                             | `T(n) = 2T(n/2) + O(n)`     | O(n log n) |

### 主定理的应用

- 二叉树遍历 - 前序、中序、后序的时间复杂度：**O(n)** n 为结点总数。

  通过主定理可以得出。

  或者，因为遍历的话每个结点访问且仅访问一次，所以时间复杂度线性于二叉树的结点个数。

- 图的遍历时间复杂度。

  **O(n)** n 为图的结点总数。

  因为遍历的话每个结点访问且仅访问一次，所以时间复杂度线性于图的顶点个数

- 搜索算法 DFS、BFS 时间复杂度是多少.

  **O(n)** n 为搜索空间的结点总数。

  因为搜索的话每个结点访问且仅访问一次。

- 二分查找：时间复杂度

  O(log n)
