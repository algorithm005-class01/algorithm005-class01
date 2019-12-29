学习笔记

**一周总结**

Queue 是 一个interface。一般有两种实现，一个是数组实现队列，一个是链表实现队列

```java
// 数组实现队列
 public ArrayQueue(int capacity) {
        this.capacity = capacity + 1; //初始化容量
        this.queue = newArray(capacity + 1); //创建一个数组
        this.head = 0;//循环队列使用
        this.tail = 0;
    }


public boolean add(T o) {
        queue[tail] = o; //尾部添加数据
        int newtail = (tail + 1) % capacity;  //类似 tail +1 可以循环使用
        if (newtail == head) //newtail == head 表示数组中数据都满了。
            throw new IndexOutOfBoundsException("Queue full");
        tail = newtail;
        return true; // we did add something
    }

    public T remove(int i) {
        if (i != 0)
            throw new IllegalArgumentException("Can only remove head of queue");
        if (head == tail) //表示数组中已经没有数据了。
            throw new IndexOutOfBoundsException("Queue empty");
        T removed = queue[head]; //从前取数据
        queue[head] = null;
        head = (head + 1) % capacity; //类似于head +1 取模目的带有循环
        return removed;
    }
```

```java
// 链表实现队列 实现类 ArrayList
//queue.remove() 方法
 private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next; //先获取 first 节点的next 节点
        f.item = null;
        f.next = null; 
        first = next; //将first 节点赋值为next 节点
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    /**
     *queue.add();
     */
   void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);//创建Node节点
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode; //链表最后节点next 指向新节点。将新节点放到链表尾部
        size++;
        modCount++;
    }
```

**优先队列**

* 实现机制一般是堆（大顶堆，小顶堆），二叉查找树

```java
//leecode 使用小顶堆 实现 返回数据流中第k大值
class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k =k;
        q =new PriorityQueue<>(k);
        for(int i =0 ;i <nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int n) {
        if(q.size() <k){
            q.offer(n);
        }else{
            if(q.peek() <n){
                q.poll();
                q.offer(n);
            }
        }
        return q.peek();
    }

```

**两数，三数之和的解题思路**

* 暴力解法，时间负载度比较高O(n*2) O(n*3)
* 使用hash表的查找时间负载度为O(1)的方式将复杂度降为O(n)但是空间负载度为O(n)

**移除数组中的重复元素，移除0 解题思路**

* 使用两个指针，空间复杂度为O(1)

**链表中是否有环解题思路**

* hashset 去重的方式
* 快慢指针的方式比较巧妙

