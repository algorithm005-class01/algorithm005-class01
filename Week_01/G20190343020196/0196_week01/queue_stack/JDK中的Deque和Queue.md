##Queue 和 Deque 都是接口。

+ Queue 接口定义的是一个队列，它包含队列的基本操作：入队（enqueue）和出队（dequeue）。

+ Deque 接口继承自 Queue 接口，表示双端队列（Double-ended queue），同时具备「队列」和「栈」的性质。



###*Queue*

Queue 接口定义如下：

它定义了 6 个方法，根据操作可以分为三类：入队、出队和遍历。

1. 入队：add() 和 offer()
   + 二者区别在于：当队列空间已满无法入队时，add() 方法会抛出异常；而 offer() 会返回 false。
2. 出队：remove() 和 poll()
   + 二者区别在于：当队列为空时，remove() 方法会抛出异常，而 poll() 会返回 null。
3. 遍历：element() 和 peek()
   + element() 和 peek() 都表示检索但不移除队列头部元素，可用于从头开始遍历队列。
   + 二者区别在于：当队列为空时，element() 方法会抛出异常，而 peek() 会返回 null。

####Queue 接口的几个方法可归纳如下：

|         | Throws exception | Returns special value |
| :------ | :--------------- | :-------------------- |
| Insert  | add(e)           | offer(e)              |
| Remove  | remove()         | poll()                |
| Examine | element()        | peek()                |



---



###Deque

+ Deque 接口继承自 Queue 接口，可以将 Deque 理解为「双端队列 」和「栈（*Stack*）」的组合。

+ 一般的队列是从尾部插入元素、头部移除元素；而双端队列则可以分别从两端插入元素、两端移除元素。

Deque 接口方法定义如下：

作为双端队列，其定义的方法可以归纳如下：

|         | First Element (Head) | Last Element (Tail) |                  |               |
| :------ | :------------------- | :------------------ | ---------------- | ------------- |
|         | Throws exception     | Special value       | Throws exception | Special value |
| Insert  | addFirst(e)          | offerFirst(e)       | addLast(e)       | offerLast(e)  |
| Remove  | removeFirst()        | pollFirst()         | removeLast()     | pollLast()    |
| Examine | getFirst()           | peekFirst()         | getLast()        | peekLast()    |

由于 Deque 继承了 Queue 接口，因此 Queue 的方法在 Deque 中也有体现，而且与 Deque 定义的方法存在如下对应关系：

| Queue Method | Equivalent Deque Method |
| :----------- | :---------------------- |
| add(e)       | addLast(e)              |
| offer(e)     | offerLast(e)            |
| remove()     | removeFirst()           |
| poll()       | pollFirst()             |
| element()    | getFirst()              |
| peek()       | peekFirst()             |

此外，Deque 还可以作为栈，有关栈的操作和在 Deque 中的对应方法如下：

| Stack Method | Equivalent Deque Method |
| :----------- | :---------------------- |
| push(e)      | addFirst(e)             |
| pop()        | removeFirst()           |
| peek()       | peekFirst()             |

Deque 还有几个独有的方法：

1. removeFirstOccurrence()

从该双端队列中移除第一次出现的指定元素；

2. removeLastOccurrence()

从该双端队列中移除最后一次出现的指定元素；

3. descendingIterator()

以相反顺序返回此双端队列中元素的迭代器，可以认为是 iterator() 反过来。

