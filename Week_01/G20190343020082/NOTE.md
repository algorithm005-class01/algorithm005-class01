###学习笔记

 - Java 8 Queue源码阅读
> Queue是一个接口，继承自集合接口Collection，表明它是一个容器，子接口有双端队列Deque，阻塞队列BlockingQueue，实现类有链表LinkedList、优先队列PriorityQueue以及阻塞队列的各种实现等。
>
> Queue提供的API包括，在队尾添加元素的两个方法add和offer，在队首弹出元素的两个方法remove和poll，以及查看队首元素的两个方法element和peek，每组两个方法的区别在于，前者失败会抛异常，而后者失败返回false或null

 - Java 8 PriorityQueue源码阅读
> 使用数组来存储元素，元素类型必须实现Comparable接口或者指定一个Comparator来进行的元素的比较。构造方法可以初始化容器大小，以及指定Comparator，或者这两者的任意缺省组合，初始默认大小11。同时可以传入其他集合来进行构造，直接将所有元素添加进来，如果传入的集合是SortedSet或本身就是PriorityQueue的话，会保留原来的Comparator，之后建大顶堆，看起来是O(n)，存储方式应该是把完全二叉树做广度优先遍历放进数组。
>
> 扩容时如果原size小于64，扩容一倍再加2，否则扩容50%
>
> 插入元素时从队尾插入，之后siftUp调整数组结构，保证大顶堆结构，弹出元素是从堆顶弹出也就是数组第0个元素，然后把队尾元素放在队首，再siftDown调整大顶堆结构。调整堆结构看起来是O(logn)。
>
> 删除任意元素remove(o)，removeEq(o)，遍历所有元素O(n)，第一个方法调用equals比较，第二个方法直接==，找到对应元素在数组中的位置，用队尾元素覆盖它，然后调整堆结构，整体复杂度应该是O(n) + O(logn)，也就是O(n)


