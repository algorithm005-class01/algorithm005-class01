# 知识点

## 3. 数组、链表、跳表

### 时间复杂度

| | 数组 Array | 链表 Linked List | 跳表 Skip List |
| --- | --- | --- | --- |
| prepend | O(1) | O(1) | O(1) |
| append | O(1) | O(1) | O(1) |
| lookup | O(1) | O(n) | O(log n) |
| insert | O(n) | O(1) | O(log n) |
| delete | O(n) | O(1) | O(log n) |

### 空间复杂度

| 数组 Array | 链表 Linked List | 跳表 Skip List |
| --- | --- | --- |
| O(n) | O(n) | O(n) |

## 4. 栈、队列、优先队列、双端队列

### 时间复杂度

| | 栈 Stack | 队列 Queue | 双端队列 Deque | 优先队列 Priority Queue |
| --- | --- | --- | --- | --- |
| insert & delete | O(1) | O(1) | O(1) | O(1) |
| lookup | O(n) | O(n) | O(n) | O(log n) |

## 解题要点

- 首先尝试暴力解题，逐层列出结果，列出几层后，用变量替代具体内容，抽象出公式
- 对空间复杂度没有要求的题目，可以尝试用空间换时间，如哨兵节点、临时队列、临时栈等
- 对于需要排查数组中元素的情况（去重、是否为某个值等），可以尝试双下标法解题
- 栈利用其先进后出的特性，可以用于值的匹配、边界的判断等

# 解题思路

## 1

https://leetcode-cn.com/problems/two-sum/submissions/

暴力穷举求解

## 21

https://leetcode-cn.com/problems/merge-two-sorted-lists/

1. 创建一个新链表并设置哨兵节点作为头部
2. 依次比较两个链表结点的值大小，从小到大放到新链表中
3. 去掉哨兵节点

## 26

https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

1. 初始化不重复元素的下标 j 为 0
2. 依次读取数组，将元素与 j 对应的元素做比较，若两者不重复，则 j + 1，并将 j + 1 位置的元素值设置为当前元素的值

## 42

https://leetcode-cn.com/problems/trapping-rain-water/submissions/

通过栈来缓存和比较边界高度，合计出面积。

## 61

https://leetcode-cn.com/problems/plus-one/submissions/

倒序遍历数组元素，若 +1 后不进位则直接返回。进位则继续遍历下一个元素，若全部元素都被遍历了，则新建一个以 1 开头，长度为原元素长度且填充 0 的数组。

## 88

https://leetcode-cn.com/problems/merge-sorted-array/

双指针从后往前遍历

## 189

https://leetcode-cn.com/problems/rotate-array/

- 使用额外数组
  1. 创建一个额外数组
  2. 遍历现有数组并将其值复制到额外数组中正确的位置里
  3. 将额外数组中的值按顺序覆盖到现有数组中
- 循环替换
- 反转数组

## 283

https://leetcode-cn.com/problems/move-zeroes/

通过双指针遍历数组，将非 0 值往前移动，余下的位置全部设置为 0

## 641

https://leetcode-cn.com/problems/design-circular-deque/submissions/

用数组实现即可。
