# 学习笔记

### 环形队列（循环队列）
#### 参考资料

- [Java版-数据结构-队列（循环队列）](https://juejin.im/post/5c95d2515188252dab3ebfc5)
- [Using an Array to represent a Circular Queue](https://www.youtube.com/watch?v=ia__kyuwGag&list=LLlpO8jYosbBe-EetMvDzbMg&index=3&t=0s)

#### 主要概念
- 先进先出
- capacity：数组容量
- front：表示队列队首，始终指向队列中的第一个元素（当队列空时，front指向索引为0的位置）
- tail：表示队列队尾，始终指向队列中的最后一个元素的下一个位置
- 元素入队，维护tail的位置，进行tail++操作，计算公式：(tail + 1) % capacity
- 元素出队，维护front的位置，进行front++操作，计算公式：(front + 1) % capacity
- 在循环队列中，总是浪费一个空间，来区分队列为满时和队列为空时的情况，也就是当 (tail + 1) % capacity == front的时候，表示队列已经满了，当front == tail的时候，表示队列为空。

#### 疑问解答
- 为什么front的计算公式为：(front + 1) % capacity ？

1. 元素出队时，弹出当前front的元素，front向数组右边移动一位，所以新的front = front + 1
2. 因为front的取值范围是[0, capacity - 1]，当front = capacity - 1时（数组的最后一位）front + 1就会出现数组越界！这时有2种方法可以处理：
 - 2.1. 判断数组越界后，直接将front赋值为0。因为是环形数组，开始循环了。
 - 2.2. 根据“余数定理”，%操作可以保证结果范围在[0, capacity - 1]内。因为front的最大值是capacity - 1。
3. 取余操作相对于每次判断是否最大索引值的方式，代码更简洁，但相对难理解。

### 接雨水
#### 解题思路：双指针
1. 定义左右2个指针left、right
2. 定义左右2个最大高度maxLeft、maxRight
3. 从左到右搜索，每次搜索只会出现以下2种情况:
 - 3.1. 左边高度 <= 右边高度
 - 3.2. 左边高度 > 右边高度
4. 第3步可以确定左边界或者右边界（高度低的一方）
5. 根据确定的左右边界进一步移动指针：
 - 5.1. 如果是左边低，left指针向右移动，遇到比自己低的，说明可以存水
 - 5.2. 如果是右边低，right指针向左移动，遇到比自己低的，说明可以存水
6. 在第5步中可以存水的时候，累加存水量（因为左右边界均已确定）
