# 学习笔记

## 1. 用 add first 或 add last 这套新的 API 改写 Deque 的代码

```java
Deque<String> deque = new LinkedList<>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

## 2. 分析 Queue 和 Priority Queue 的源码

### Queue 源码分析

java 中的 Queue 是一个接口。Queue 提供了基础的插入，删除和检查操作。

主要有 3 个方法，每一种都以两种形式存在：一种在操作失败时引发异常，另一种返回一个特殊值（ null或false，取决于操作）。

| 方法 | 返回异常 | 返回特殊值 |
| :-: | :-: | :-:|
| 插入 | add(E e) | offset(E e) |
| 删除 | remove() |poll()|
| 检查 | element() | peek()|

### Priority Queue 的源码

PriorityQueue 是 java 中的一个 class，实现了 Queue 接口。

PriorityQueue 的元素根据其 **自然顺序进行排序**，或根据 Comparator 队列构造时的提供者进行排序，具体取决于所使用的构造函数。**优先级队列不允许null元素**。

PriorityQueue 的插入与取出是有序的，是根据优先级排序。

## 学习总结

这周比较狼狈，首先是低估了题目的难度，而是低估了作业量。

首先是没有看到作业题目只做 2 道题，因此把第三课的题目都做了，因为基础比较差，耗费了比较多的时间。导致第四课的题目时间不太充裕。

### 第三课的感受

这周的感受就是，递归真的是无处不在。

练习题目与作业题目，除了暴力破解外，我几乎想不出任何一种其他的办法(基础实在是太差了)，在看到别人的解法时，无数次怀疑自己是不是不适合学算法。

不过，在经过这几天的练习外，有些题目能够想出用什么方法可以求解，但是代码还写不出来，不过也比之前是有一些进步的吧。

疑惑就是，五毒刷题的第一遍背诵，第二遍写，第三遍隔天练习，这些完成后，一些题目再次去看，只能大概想起是什么解法，但是代码就忘了。还是要多练。

### 第四课的感受

第三课的数组、链表、递归至少还会经常用到，理解起来也不是太难。但是第四课的栈、队列就比较难理解了。

首先是比较难想到，而是比较难理解。

通过课程和练习题后，对栈和队列有了些许的了解，具体遇到题目还是没有思路，还是要先看解法。

大概还是做得少吧。

## 最后，下周继续努力

路漫漫其修远兮，继续加油吧。