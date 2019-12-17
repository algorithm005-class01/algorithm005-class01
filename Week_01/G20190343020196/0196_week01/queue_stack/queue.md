



###**数据搬移**！

随着不停地进行入队、出队操作，head 和 tail 都会持续往后移动。当 tail 移动到最右边，即使数组中还有空闲空间，也无法继续往队列中添加数据了。这个问题该如何解决呢？



我们在出队时可以不用搬移数据。如果没有空闲空间了，我们只需要在入队时，再集中触发一次数据的搬移操作。

![img](https://static001.geekbang.org/resource/image/09/c7/094ba7722eeec46ead58b40c097353c7.jpg)

***循环队列***

![img](https://static001.geekbang.org/resource/image/58/90/58ba37bb4102b87d66dffe7148b0f990.jpg)

我们成功避免了数据搬移操作。要想写出没有 bug 的循环队列的实现代码，我个人觉得，最关键的是，确定好**队空和队满**的判定条件。

非循环队列：队满的判断条件是 tail == n，队空的判断条件是 head == tail。

循环队列：队列为空的判断条件仍然是 head == tail。

当队满时，(tail+1)%n=head。你有没有发现，当队列满时，图中的 tail 指向的位置实际上是没有存储数据的。所以，循环队列**会浪费一个数组的存储空间。**

你有没有发现，当队列满时，图中的 tail 指向的位置实际上是没有存储数据的。所以，循环队列会浪费一个数组的存储空间。

```java
public class CircularQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public CircularQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 队列满了
    if ((tail + 1) % n == head) return false;
    items[tail] = item;
    tail = (tail + 1) % n;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) return null;
    String ret = items[head];
    head = (head + 1) % n;
    return ret;
  }
}
```





---

**阻塞队列**

![img](https://static001.geekbang.org/resource/image/5e/eb/5ef3326181907dea0964f612890185eb.jpg)

就是在**队列为空**的时候，从**队头取数据会被阻塞**。因为此时还没有数据可取，直到队列中有了数据才能返回；如果**队列已经满了**，那么**插入数据的操作就会被阻塞**，直到队列中有空闲位置后再插入数据，然后再返回。轻松实现一个“生产者 - 消费者模型”！

比如前面的例子，我们可以多配置几个“消费者”，来应对一个“生产者”。在多线程情况下，会有多个线程同时操作队列，这个时候就会存在线程安全问题，那如何实现一个线程安全的队列呢？



----

当我们向固定大小的线程池中请求一个线程时，如果线程池中没有空闲资源了，这个时候线程池如何处理这个请求？是拒绝请求还是排队请求？各种处理策略又是怎么实现的呢？



两种处理策略。

第一种是非阻塞的处理方式，直接拒绝任务请求；

另一种是阻塞的处理方式，将请求排队，等到有空闲线程时，取出排队的请求继续处理。那如何存储排队的请求呢？



基于链表的实现方式，可以实现一个支持无限排队的无界队列（unbounded queue），但是可能会导致过多的请求排队等待，请求处理的响应时间过长。所以，针对响应时间比较敏感的系统，基于链表实现的无限排队的线程池是不合适的。



##实战工程只用Deque:  (双端队列)

+ 实战 只用 Deque: Double-End Queue (双端队列)
+ 两端都可进出
+ ![image-20191214093452649](/Users/marslee/Library/Application Support/typora-user-images/image-20191214093452649.png)
+ add, delete 皆为 O(1), lookup O(n)

## 并发式编程

+ concurrent
+ blocking
+ non-blocking

##Priority Queue(优先队列)

+ insert: O(1)
+ 取出操作： O(log N) 按照元素优先级取出，vip可以插队，即vip可以安排头或尾
+ 底层具体事项的数据结构很多种方式
  + heap
  + BST
  + treap
  + 用数组比较慢，每次插入要重新排序



source stack java

java source code 

stack java 12

