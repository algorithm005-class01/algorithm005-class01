### 本周学习了 **数组**、**链表**、**栈**、**队列** 四个基础的数据结构
- 对于 **数组** 类型的题，多使用 双指针 技巧来解题，能实现 O(n) 的算法，比较困难的点是计算特殊的 数组index 值

- 对于 **链表** 类型的题，涉及到交换元素的，可能需要创建一个 dummy 节点来辅助，比较困难的是交换节点时的具体步骤，解决方法是 在大脑中建模，让自己脑中有一个交换节点的步骤动画，按照这个动画来写代码准没问题

- 对于 **栈** 类型的题，注意一下本身的 FILO 特性即可

- 对于 **队列** 类型的题，注意一下本身的 LIFO 特性即可，也有双端队列，两端都可以 offer、poll

- 操作 **数组** 跟 **链表** 的技巧比较难，需要多加练习才能熟练掌握。在脑中有这些操作的具体的执行画面，能在写题时更加轻松。

### 总结一下现有遇到的对 数组 的操作核心：
- 操作双指针指针
    - 可以是两端向中间靠的指针，
    - 也可以是同一个方向，但指针速度可能因为某些判断条件导致的不一致(双下标默认同步更新, 慢下标遇到条件则停留)
- 双下标左右相遇可以翻转数组

### 总结一下现有遇到的对 链表 的操作核心:
- 快慢指针
    - 用于检测链表是否有环
    - 取链表中央节点
- 删除元素
    - 删除重复元素: 将目标元素的 val、next 赋值为 目标元素的下一个节点的值
    - 删除元素: 需要更改目标元素的前后节点，所以需要 dummy 节点来辅助 
- 交换两个或更多节点，需要 dummy 节点辅助

### 体会
要想算法写的好，大脑一定的有画面，常用的操作套路就那么多，熟能生巧，把它们转化为思维的工具，解答问题时就会潜意识的浮现出相关联的可行性方案。

另外五毒神掌被我打成降龙十巴掌 写五遍 那是真的太少了 😢😭

### 题目1 改写 Deque:
```java
	Deque<String> deque = new LinkedList<String>();
	deque.offerLast("a"); 
	deque.offerLast("b");
	deque.offerLast("c"); 
	System.out.println(deque);
	String str = deque.peekFirst(); 
	System.out.println(str); 
	System.out.println(deque);
	while (deque.size() > 0) {
		System.out.println(deque.pollLast()); 
	} 
	System.out.println(deque);
```

### 题目2 Deque 源码分析:
Deque 提供了对队列两端的出入队方法, 
- offerFirst
- offerLast
- pollFirst
- pollLast
- peekFirst
- peekLast
提供了审视队列首尾、队列大小、队列中是否含有目标元素的方法
- peekFirst
- peekLast
- size
- contains

### 题目3 PriorityQue 源码分析:
- 实现了 Queue interface
- 核心是通过一个传入可选的 comparator 来进行优先级的比较，在出队时，可以通过它来得到当前最优先出队的队列元素
- PriorityQue 支持动态扩容