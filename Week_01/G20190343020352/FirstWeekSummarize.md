#### 用 add first 或 add last 这套新的 API 改写 Deque 的代码
```
    Deque<Integer> deque = new LinkedList<Integer>();

    deque.addFirst(3);
    deque.addFirst(2);
    deque.addFirst(1);
    Integer first = deque.getFirst();
    System.out.println(first.equals(1));

    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);
    Integer last = deque.getLast();
    System.out.println(last.equals(6));

    deque.removeFirst();
    System.out.println(deque.getFirst().equals(2));

    deque.removeLast();
    System.out.println(deque.getLast().equals(5));

    System.out.println(deque);
```

#### 分析Queue和Priority Queue的源码

##### Queue
Queue是一个接口, 定义了实现此接口的类需要实现的方法. Queue是一个先进先出(FIFO First-In-First-Out)的数据结构, 
接口中的方法以两种形式存在:一种 在操作失败时抛出异常，另一种 返回特殊值

|     | Throws exception  | Returns special value  |
|  ----  | ----  | ----  |
| Insert  | add(e) | offer(e) |
| Remove  | remove() | poll() |
| Examine  | element() | peek() |

##### PriorityQueue
PriorityQueue是一个基于priority heap实现的无界优先队列. 
PriorityQueue的元素按照自然顺序排序或者根据构造方法提供的比较器进行排序, 具体如何排序取决于使用哪个构造器.
PriorityQueue不允许使用null元素, 如果插入null, 会抛出NullPointerException. 依靠自然顺序的PriorityQueue
不允许插入不可比较的对象, 如果插入不可比较对象, 可能会抛出ClassCastException. 此队列的头是按指定排序方式确定
的最小元素. 如果多个元素都是最小值, 则头可能是任意一个. 可以通过 poll, remove, peek, element, 这些方法访问队列头元素.
PriorityQueue是无界的, 但有一个默认容量(DEFAULT_INITIAL_CAPACITY=11), 当然也可以通过构造方法指定. 
随着不断向优先级队列添加元素, 其容量会自动增加.
PriorityQueue是线程不安全的, 如果线程安全需要使用PriorityBlockingQueue.

| method | 时间复杂度 |
| :-----: | :----: |
| offer | O(log(n) |
| poll | O(log(n) |
| remove() | O(log(n)) |
| add | O(log(n) |
| remove(Object) | O(n) |
| contains(Object) | O(n) |
| peek | O(1) |
| element | O(1) |
| size | O(1) |

PriorityQueue代表着一个平衡的二叉堆：队列[n]的两个孩子分别是队列[2*n+1]和队列[2*(n+1)]. PriorityQueue的元素根据构造队列时
提供的 Comparator 进行排序, 或者按照其自然顺序进行排序: 
1. 如果比较器为空, 则堆中的每一个结点n和它的的子节点d, 有n<=d.
2. 如果队列不为空的话, 则最小值元素是队列[0].



