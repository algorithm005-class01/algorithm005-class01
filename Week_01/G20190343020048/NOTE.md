学习笔记
### 第一周学习总结
1. 善于使用双指针解决数组问题，双指针主要分为两类
    * 快慢双指针，经常用于移动和交换数据
    * 左右双指针，经常使用左右夹逼的方式来达到目标解，
    有时能够将O(n^2)的时间复杂度降为O(n)
2. 跳表的实现使用了两个思想：升维和空间换时间，能够将链表的查询时间复杂度降为O(log(n))

### 第四课课后题
1. 用add first或add last这套新的API改写Deque的代码
    
    ```java
    Deque<String> deque = new LinkedList<String>();
    deque.addLast("a");
    deque.addLast("b");
    deque.addLast("c");
    System.out.println(deque);
    
    String str = deque.getLast();
    System.out.println(str);
    System.out.println(deque);
    
    while (deque.size() > 0){
        System.out.println(removeLast());
    }
    System.out.println(deque);
    ```

2. 分析Queue和Priority Queue的源码

主要分析Java的PriorityQueue类，主要包括其构造方法及offer和poll方法。
* 构造方法，可以看到PriorityQueue底层是一个Object数组
```java
public PriorityQueue(int initialCapacity) {
   this(initialCapacity, null);
}

public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
    if (initialCapacity < 1)
        throw new IllegalArgumentException();
    this.queue = new Object[initialCapacity];
    this.comparator = comparator;
}
```

* offer方法，可以看到主要是siftUp方法，实现了建堆过程中的节点的上浮功能，因此Java中PriorityQueue实际上是一个堆
```java
public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e);
    return true;
}

private void siftUp(int k, E x) {
    if (comparator != null)
        siftUpUsingComparator(k, x);
    else
        siftUpComparable(k, x);
}

private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (key.compareTo((E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}
```

* poll()方法，可以看到主要是siftDown方法，是将堆的最后一个元素放入堆顶然后下沉的过程
```java
public E poll() {
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

private void siftDown(int k, E x) {
    if (comparator != null)
        siftDownUsingComparator(k, x);
    else
        siftDownComparable(k, x);
}

private void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        int child = (k << 1) + 1; // assume left child is least
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
        if (key.compareTo((E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = key;
}
```