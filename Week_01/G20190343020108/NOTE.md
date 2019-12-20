# 第一周学习总结（数组、链表、跳表、栈、队列）

## 1. 数组

### 基本实现和特性

#### 查询

通过内存地址直接访问，时间复杂度为 O(1)

#### 增加元素

需要拷贝移动元素，时间复杂度为 O(n)

#### 删除元素

需要拷贝移动元素，时间复杂度为 O(n)

### 工业级源码实现

[Java ArrayList 源码](http://developer.classpath.org/doc/java/util/ArrayList-source.html)

```java
/**
 * Returns the lowest index at which element appears in this List, or
 * -1 if it does not appear.
 *
 * @param e the element whose inclusion in the List is being tested
 * @return the index where e was found
 */
public int indexOf(Object e)
{
  for (int i = 0; i < size; i++)
    if (equals(e, data[i]))
      return i;
  return -1;
}

/**
 * Retrieves the element at the user-supplied index.
 *
 * @param index the index of the element we are fetching
 * @throws IndexOutOfBoundsException if index &lt; 0 || index &gt;= size()
 */
public E get(int index)
{
  checkBoundExclusive(index);
  return data[index];
}

/**
 * Appends the supplied element to the end of this list.
 * The element, e, can be an object of any type or null.
 *
 * @param e the element to be appended to this list
 * @return true, the add will always succeed
 */
public boolean add(E e)
{
  modCount++;
  if (size == data.length)
    ensureCapacity(size + 1);
  data[size++] = e;
    return true;
}

/**
 * Removes the element at the user-supplied index.
 *
 * @param index the index of the element to be removed
 * @return the removed Object
 * @throws IndexOutOfBoundsException if index &lt; 0 || index &gt;= size()
 */
public E remove(int index)
{
  checkBoundExclusive(index);
  E r = data[index];
  modCount++;
  if (index != --size)
    System.arraycopy(data, index + 1, data, index, size - index);
  // Aid for garbage collection by releasing this pointer.
  data[size] = null;
  return r;
}
```

## 2. 链表

### 基本实现和特性

每个结点由元素 Value 和后继指针 next 组成

#### 查询

通过头结点遍历，时间复杂度为 O(n)

#### 增加元素

在已知结点插入新结点，插入操作的时间复杂度为 O(1)

#### 删除元素

删除已知结点，删除操作的时间复杂度为 O(1)

### 双链表

在单链表的基础上，每个结点增加了一个前驱指针 prev。头结点的 prev 指针指向 null，尾结点的 next 指针指向 null。

### Linked List 实现代码

- [Linked List 的标准实现代码](http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
- [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked Lists/code/LinkedList.java)
- [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)

### 链表与数组的时间复杂度对比

|         | Array | Linked List |
| ------- | :---: | :---------: |
| prepend | O(1)  |    O(1)     |
| append  | O(1)  |    O(1)     |
| lookup  | O(1)  |    O(n)     |
| insert  | O(n)  |    O(1)     |
| delete  | O(n)  |    O(1)     |

## 3. 跳表

**链表的主要缺陷**：查询操作的时间复杂度较高，为O(n)。

### 如何给链表加速

#### 1. 简单优化

添加头尾指针，访问头尾结点的时候，时间复杂度为 O(1)。

#### 2. 进一步优化

添加第一级索引

添加第二级索引

以此类推，添加多级索引

访问结点 62 的时候，通过索引查询次数减少到 5 次。

**这里采用的思想就是升维思想，或者叫做空间换时间。**

### 跳表查询的时间复杂度分析

假设每一级索引的结点个数是它上一级索引结点个数的 1 / 2，那么第 k 级索引结点的个数就是 n / (2 ^ k)。

假设索引一共有 k 级，最高级的索引一共有 2 个结点。n / (2 ^ h) = 2，**h = log~2~n - 1**。

**索引的高度为 O(logn)**

**在跳表中查询任意数据的时间复杂度为 O(logn)。**

### 跳表查询的空间复杂度分析

通过归纳：

- 原始链表有 n 个结点，以每两个结点建立一个索引结点，每层索引的结点数从低到高分别为：`n/2, n/4, n/8, ..., 8, 4, 2`

- 原始链表有 n 个结点，以每三个结点建立一个索引结点，每层索引的结点数从低到高分别为：`n/3, n/9, n/27, ..., 9, 3, 1`

通过等比数列求和，忽略前面的系数，最后求得**空间复杂度是 O(n)**。

### 现实中的跳表形态

在现实中，由于跳表增加或删除结点，**导致跳表中需要经常维护索引**，所以歌姬索引之间索引的结点个数步长并不定相等。

### 在工程中的应用

#### LRU Cache - Linked List

[LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache)

#### Redis - Skip List

[跳跃表](http://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html)

- 跳跃表是一种随机化数据结构，查找、添加、删除操作都可以在对数期望时间下完成。
- 跳跃表目前在 Redis 的唯一作用，就是作为有序集类型的底层数据结构（之一，另一个构成有序集的结构是字典）。
- 为了满足自身的需求，Redis 基于 William Pugh 论文中描述的跳跃表进行了修改，包括：
  1. `score` 值可重复。
  2. 对比一个元素需要同时检查它的 `score` 和 `memeber` 。
  3. 每个节点带有高度为 1 层的后退指针，用于从表尾方向向表头方向迭代。

[为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](http://www.zhihu.com/question/20202931)

## 栈和队列的基本实现和特性

栈和队列都是一种**操作受限**的线性数据结构。他们用来解决特定场景下的问题。

### 栈 Stack

操作上符合”后进先出“特点的数据结构。

#### 操作的时间复杂度

入栈（插入）：O(1)

出栈（删除）：O(1)

### 队列 Queue

操作上符合”先进先出“特点的数据结构。

#### 操作的时间复杂度

入队（插入）：O(1)

出队（删除）：O(1)

### 双端队列 Deque : Double-End Queue

两端都可以进出的队列。

![image-20191213113232451](./images/deque-diagram.png)

#### 操作的时间复杂度

入队（插入）：O(1)

出队（删除）：O(1)

### 优先队列 Priority Queue

优先队列中，元素被赋予了优先级。具有最高优先级的元素最先出队。

#### 操作的时间复杂度

入队（插入）：O(1)

出队（删除）：O(logn) - 按照元素的优先级取出

底层具体实现的数据结构较为多样和复杂：heap, bst, treap。

## 工程实现

### Stack 的工程实现

#### doc

https://docs.oracle.com/javase/10/docs/api/java/util/Stack.html

#### 分析

Java 中的 Stack 是一个类，代表了后进先出（last-in-first-out）这一类特点的数据结构。本身继承自 `Vector`

> Java 10 以后推荐使用 Deque 接口及实现其接口的类替换原生的 Stack 类， 因为在高级语言中提供更一致和更丰富的操作。

#### API

| 修饰器以及类型 | 方法             | 描述                                |
| -------------- | ---------------- | ----------------------------------- |
| boolean        | empty()          | 判断栈是否为空                      |
| E              | peek()           | 读取栈顶元素（不删除该元素）        |
| E              | pop()            | 删除并返回栈顶元素                  |
| E              | push(E item)     | 向栈顶添加元素                      |
| int            | search(Object o) | 在栈中搜索元素并返回下标（1-based） |

#### 源码

http://developer.classpath.org/doc/java/util/Stack-source.htm

##### push

```java
public T push (T item) {
	addElement(item); // Vector 的 addElement 方法
  return item;
}
```

##### pop

```java
public synchronized T pop () {
  if (elementCount == 0)
    throw new EmptyStackException();
  modCount++;
  T obj = elementData[--elementCount];
  elementData[elementCount] = null; // 将原来的栈顶元素置空
  return obj
}
```

##### peek

```java
public synchronized T peek () {
 if (elementCount == 0)
   throw new EmptyStackException();
 return elementData[elementCount - 1]; 
}
```

##### empty

```java
public synchronized boolean empty () {
  return elementCount == 0;
}
```

##### search

```java
// 返回搜索元素在栈中的位置
// 栈顶元素位置为 1， 其他元素的位置为深度+1
public synchronized int search (Object o) {
  int i = elementCount;
  while (--i >= 0) {
    if (equals(o, elementData[i]))
      return elementCount - i;
  }
  return -1;
}
```

### Queue 的工程实现

#### doc

https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Queue.html

#### 分析

Java 中的 Queue 被定义为一个**接口**，属于 Java Collections Framework 下的成员。

Queue 通常按照先进先出（first-in-first-out）的方式存储元素。

Queue 提供的三个基本方法中分别有两个版本：抛出异常与不抛出异常。

常见的实现了 Queue 接口的类有：

- ArrayDeque
- ConcurrentLinkedDeque, 
- ConcurrentLinkedQueue,
- LinkedList
- PriorityQueue

#### API

##### 可能抛出异常的版本

| 修饰器以及类型 | 方法      | 描述                                           |
| -------------- | --------- | ---------------------------------------------- |
| boolean        | add(E e)  | 将指定元素插入到队列中，若超出容量，则抛出异常 |
| E              | remove()  | 读取并删除队头元素                             |
| E              | element() | 读取队头元素（不删除该元素）                   |

##### 不抛出异常，返回特定值的版本

| 修饰器以及类型 | 方法       | 描述                                            |
| -------------- | ---------- | ----------------------------------------------- |
| boolean        | offer(E e) | 将指定元素插入到队列中，超出容量，则不插入      |
| E              | poll()     | 读取并删除队头元素，如果队头为空，返回 null     |
| E              | peek()     | 读取队头元素（不删除该元素），队列为空返回 null |

#### 源码

http://fuseyism.com/classpath/doc/java/util/Queue-source.html

```java
public interface Queue<E> extends Collection<E> { 
	boolean add(E e);
  boolean offer(E e);
  E remove();
  E poll();
  E element();
  E peek();
}
```

### Priority Queue 的工程实现

#### doc

https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html

#### 分析

在 Java 中 PriorityQueue 类 实现了 Queue 接口，是基于 Priority Heap 实现的。

PriorityQueue 中的元素按照 natural ordering 存储，或者按照构造函数中提供的 Comparator 来排序。

Priority Queue 中不允许插入 null 值。

Priority Queue 中的 head 队头元素是**优先级最低的**。

##### 关于时间复杂度

- Enqueue, dequeue methods (offer, poll, remove): **O(logn)**.
- remove(Object o), contains(Object o): O(n).
- Retrival methods (peek, element, size): O(1).

#### API

| 修饰器以及类型        | 方法               | 描述                                                         |
| --------------------- | ------------------ | ------------------------------------------------------------ |
| boolean               | add(E e)           | 将指定元素插入到队列中，若超出容量，则抛出异常               |
| void                  | clear()            | 清空队列中的元素                                             |
| Comparator<? super E> | comparator()       | 返回用于如何排序队列中元素的比较器，如果是 null 的话，则按照元素的自然顺序排列 |
| boolean               | contains(Object o) | 判断是否包含某个元素                                         |
| Iterator<E>           | iterator()         | 返回迭代器                                                   |
| boolean               | offer(E  e)        | 将指定元素插入到优先队列中                                   |
| boolean               | remove(Object e)   | 删除队列中第一个匹配到的元素                                 |
| Object []             | toArray()          | 返回一个包含队列所有元素的数组                               |
| < T > T[]             | toArray(T[] a )    | 返回一个包含队列所有元素的数组，类型是运行时指定的类型       |

#### 源码

http://developer.classpath.org/doc/java/util/PriorityQueue-source.html

http://www.docjar.com/html/api/java/util/PriorityQueue.java.html (✅)

该源码实现的 Priority Queue 是基于 balanced binary heap，队列 queue[n] 的两个孩子分别是 queue[2*n + 1] 和 queue[2 * (n+1)] 。队列中优先级最低的元素存储在 queue[0]。

##### add and offer

```java
public boolean add (E e) {
  return offer(e);
}

public boolean offer (E e) {
  if (e == null)
    throw new NullPointerException();
  modCount++;
  int i = size;
  if (i >= queue.length)
    grow(i + 1); // 扩容
  size = i + 1;
  if (i == 0)
    queue[0] = e; // 添加第一个元素
  else
    siftUp(i, e); // 添加其他元素
  return true;
}
```

##### peek, indexOf

```java
public E peek () {
  return (size == 0) ? null : (E) queue[0];
}

private int indexOf(Object o) {
  if (o != null) {
    for (int i = 0; i < size; i++) {
      if (o.equals(queue[i]))
        return i;
    }
  }
  return -1;
}
```

##### remove and removeAt

```java
/**
 * @param o element to be removed from this queue, if present
 * @return {@code true} if this queue changed as a result of the call
 */
public boolean remove(Object o) {
	int i = indexOf(o);
  if (i == -1) {
    return false;
  } else {
    removeAt(i);
    return true;
  }
}

public void remove() {
  if (expectedModCount != modCount)
    throw new ConcurrentModificationException();
  if (lastRt != -1) {
    E moved = PriorityQueue.this.removeAt(lastRet);
    if (moved == null)
      cursor--;
    else {
      if (forgetMeNot == null) 
        forgetMeNot = new ArrayDeque<>();
      forgetMeNot.add(moved);
    }
  } else if (lastRetElt != null) {
    PriorityQueue.this.removeEq(lastRetElt);
    lastRetElt = null;
  } else {
    throw new IllegalStateException();
  }
  expectedModCount = modCount;
}

E removeAt(int i) {
  modCount++;
  int s = --size;
  if (s == i) // remove at last element
    queue[i] = null;
  else {
    E moved = (E) queue[s];
    queue[s] = null;
    siftDown(i, moved);
    if (queue[i] == moved) {
      siftUp(i, moved);
      if (queue[i] != moved) {
        return moved;
      }
    }
  }
  return null;
}
```

##### clear

```java
public void clear () {
  modCount++;
  for (int i = 0; i < size; i++)
    queue[i] = null;
  size = 0;
}
```

##### poll

```java
public E poll () {
  if (size == 0)
    return null;
  int s = --size;
  modCount++;
  E result = (E) queue[0];
  E x = (E) queue[s];
  queue[s] = null;
  if (s != 0)
    siftDown(0, x);
  return result;
}
```

##### contains

```java
public boolean contains (Object o) {
  return indexOf(o) >= 0;
}
```

### Deque 的工程实现

#### doc

https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Deque.html

#### 分析

Deque 在 Java 中被定义为接口，它是一种线性集合，支持在两端插入和删除。

Deque 提供的六个基本方法中分别有两个版本：抛出异常与不抛出异常。

常见的实现了 Queue 接口的类有：

- ArrayDeque
- ConcurrentLinkedDeque
- LinkedBlockingDeque
- LinkedList

#### API

##### 可能抛出异常的版本

| 修饰器以及类型 | 方法          | 描述                                                     |
| -------------- | ------------- | -------------------------------------------------------- |
| void           | addFirst(E e) | 在队列首端将指定元素插入到队列中，若超出容量，则抛出异常 |
| E              | removeFirst() | 读取并删除队头元素                                       |
| E              | getFirst()    | 读取队头元素（不删除该元素）                             |
| void           | addLast(E e)  | 在队列尾端将指定元素插入到队列中，若超出容量，则抛出异常 |
| E              | removeLast()  | 读取并删除队尾元素                                       |
| E              | getLast()     | 读取队尾元素（不删除该元素）                             |

##### 不抛出异常，返回特定值的版本

| 修饰器以及类型 | 方法            | 描述                                                 |
| -------------- | --------------- | ---------------------------------------------------- |
| boolean        | offerFirst(E e) | 在队列首端将指定元素插入到队列中，超出容量，则不插入 |
| E              | pollFirst()     | 读取并删除队头元素，如果队头为空，返回 null          |
| E              | peekFirst()     | 读取队头元素（不删除该元素），队列为空返回 null      |
| boolean        | offerLast(E e)  | 在队列首端将指定元素插入到队列中，超出容量，则不插入 |
| E              | pollLast()      | 读取并删除队尾元素，如果队头为空，返回 null          |
| E              | peekLast()      | 读取队尾元素（不删除该元素），队列为空返回 null      |

##### 其余方法，可能会抛出异常的版本

| 修饰器以及类型 | 方法      | 描述                                                 |
| -------------- | --------- | ---------------------------------------------------- |
| boolean        | add(E e)  | 将指定元素插入到队列*尾端*中，若超出容量，则抛出异常 |
| E              | remove()  | 读取并删除队列头元素                                 |
| E              | element() | 读取队头元素（不删除该元素）                         |

##### 其余方法，不抛出异常，返回特定值的版本

| 修饰器以及类型 | 方法       | 描述                                             |
| -------------- | ---------- | ------------------------------------------------ |
| boolean        | offer(E e) | 将指定元素插入到队列*尾端*中，超出容量，则不插入 |
| E              | poll()     | 读取并删除队头元素，如果队头为空，返回 null      |
| E              | peek()     | 读取队头元素（不删除该元素），队列为空返回 null  |

#### 源码

```java
public interface Deque<E> extends Queue<E> {
  void addFirst (E e);
  void addLast (E e);
  boolean offerFirst (E e);
  boolean offerLast (E e);
  E removeFirst ();
  E removeLast ();
  E pollFirst ();
  E pollLast ();
  E getFirst ();
  E getLast ();
  E peekFirst ();
  E peekLast ();
  boolean removeFirstOccurrence (Object o);
  boolean removeLastOccurrence (Object o);
  /* Queue Methods */
  boolean add (E e);
  boolean offer (E e);
  E remove ();
  E poll ();
  E element ();
  E peek ();
  /* Stack methods */
  void push (E e);
  E pop ();
  /* Collection Methods */
  boolean remove (Object o);
  boolean contains (Object o);
  public int size ();
  Iterator<E> iterator ();
  Iterator<E> descendingIterator ();
}
```

## 接口使用示例

```java
import java.util.*;

public class App {
    public static void main(final String[] args) throws Exception {
        stackTest();
        queueTest();
        dequeTest();
        dequeTest2();
        dequeTest3();
    }

    public static void stackTest() {
        final Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        final Integer topElement = stack.peek();
        System.out.println(topElement);
        System.out.println(" 3 的位置 " + stack.search(3));
    }

    public static void queueTest() {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue);

        String polledElement = queue.poll();
        System.out.println(polledElement);
        System.out.println(queue);

        String peekedElement = queue.peek();
        System.out.println(peekedElement);
        System.out.println(queue);

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }

    }

    public static void dequeTest() {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String peekStr = deque.peek();
        System.out.println(peekStr);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.print(deque);
    }

    // 使用 addFirst, removeFirst
    public static void dequeTest2() {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String peekStr = deque.peek();
        System.out.println(peekStr);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }

        System.out.print(deque);
    }

   // 使用 addLast, removeLast
    public static void dequeTest3() {
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String peekStr = deque.peek();
        System.out.println(peekStr);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeLast());
        }

        System.out.print(deque);
    }
}
```

## 实战问题总结

1. 什么样的题目可以用栈来解决：具有最近相关性。

2. 特定的面试题目：只用队列来实现栈或者只用栈来实现队列。

   一般需要使用两个队列或者两个栈来解决。

3. 滑动窗口的问题可以用队列去解决。
