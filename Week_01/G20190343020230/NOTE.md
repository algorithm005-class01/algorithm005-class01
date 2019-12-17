# 【0230_Week 01】第一周总结

## 一. 学习总结
几个学习重点记录下来，以便以后复习
1. 栈：操作系统给每个线程分配了一块独立的内存空间，这块内存被组织成“栈”这种结构，用来存储函数调用时的临时变量。每进入一个函数，就会将其中的临时变量作为栈帧入栈，当被调用函数执行完成，返回之后，将这个函数对应的栈帧出栈。
2. 链表：五个常见的链表操作需要掌握：1.单链表反转，2.链表中环的检测，3.两个有序链表合并，4.删除链表倒数第n个节点，5.求链表的中间节点
3. 递归：写递归代码的关键就是找到如何将大问题分解为小问题的规律，并且基于此写出递推公式，然后再推敲终止条件，最后将递推公式和终止条件翻译成代码。优点：代码的表达力很强，写起来简洁。缺点：空间复杂度高、有堆栈溢出风险、存在重复计算、过多的函数调用会耗时较多等问题。
4. 双端队列：双端队列是与队列类似的项的有序集合。双端队列有两个端部，首部和尾部，并且项在集合中保持不变。双端队不同的地方是添加和删除项是非限制性的。可以在前面或后面添加新项；同样，可以从任一端移除现有项。

## 二. 用add first或add last这套新的API改写Deque的代码
```
Deque<String> deque = new LinkedList<>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);
String str = deque.getFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);
```
    
## 三. 分析Queue和Priority Queue的源码
1. 继承自AbstractQueue，并且是Queue的实现类
2. 常用方法：offer，poll
3. 特性：PriorityQueue会根据排序规则决定谁在队头，谁在队尾，比如入队是：12534， 出列是：12345，存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器。
4. 是一种无界的，线程不安全的队列

根据上述掌握的特性以及API的调用方式来分析一下源码，
1. 定义队列比较器，如果为null则使用自然排序

```
    /**
     * The comparator, or null if priority queue uses elements'
     * natural ordering.
     */
    private final Comparator<? super E> comparator;
```

2. 在PriorityQueue里面，offer和add其实没什么区别，add本身调用了offer方法，如果插入失败则返回false，offer的源码如下：

```
    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(E e) {
        return offer(e);
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        siftUp(i, e);
        size = i + 1;
        return true;
    }
```

在offer方法里，调用了grow方法，该方法实现了自动扩容，就是再申请一个更大的数组，并通过Arrays.copyOf方法将原数组的元素复制过去，

```
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }
```

在offer方法里，另一个需要注意的方法是siftUp(int k, E x)方法，该方法用于插入元素x并维持堆的特性

```
    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * To simplify and speed up coercions and comparisons, the
     * Comparable and Comparator versions are separated into different
     * methods that are otherwise identical. (Similarly for siftDown.)
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x, queue, comparator);
        else
            siftUpComparable(k, x, queue);
    }

    private static <T> void siftUpComparable(int k, T x, Object[] es) {
        Comparable<? super T> key = (Comparable<? super T>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = es[parent];
            if (key.compareTo((T) e) >= 0)
                break;
            es[k] = e;
            k = parent;
        }
        es[k] = key;
    }
```

3. poll获取并删除队首元素

```
    public E poll() {
        final Object[] es;
        final E result;

        if ((result = (E) ((es = queue)[0])) != null) {
            modCount++;
            final int n;
            final E x = (E) es[(n = --size)];
            es[n] = null;
            if (n > 0) {
                final Comparator<? super E> cmp;
                if ((cmp = comparator) == null)
                    siftDownComparable(0, x, es, n);
                else
                    siftDownUsingComparator(0, x, es, n, cmp);
            }
        }
        return result;
    }
```