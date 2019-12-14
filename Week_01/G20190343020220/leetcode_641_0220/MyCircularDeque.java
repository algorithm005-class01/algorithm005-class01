package leetcode_641_0220;
/*
设计实现双端队列。
你的实现需要支持以下操作：

MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。
示例：

MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
circularDeque.insertLast(1);			        // 返回 true
circularDeque.insertLast(2);			        // 返回 true
circularDeque.insertFront(3);			        // 返回 true
circularDeque.insertFront(4);			        // 已经满了，返回 false
circularDeque.getRear();  				// 返回 2
circularDeque.isFull();				        // 返回 true
circularDeque.deleteLast();			        // 返回 true
circularDeque.insertFront(4);			        // 返回 true
circularDeque.getFront();				// 返回 4
 
 

提示：

所有值的范围为 [1, 1000]
操作次数的范围为 [1, 1000]
请不要使用内置的双端队列库。

* */

/**
 * @author Darcy
 * @date 2019-12-12 11:04
 */
public class MyCircularDeque {
    /**
     * 数组
     */
    transient Integer[] elements;

    /**
     * 头指针
     */

    transient int head;
    /**
     * 尾指针
     */
    transient int tail;

    /**
     * 最小数组大小
     */
    private static final int MIN_INITIAL_CAPACITY = 8;

    /**
     * 扩容方法 每次都是翻倍的
     */
    private void doubleCapacity() {
        assert head == tail;
        int p = head;
        int n = elements.length;
        int r = n - p; // number of elements to the right of p
        int newCapacity = n << 1;
        if (newCapacity < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Integer[] a = new Integer[newCapacity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = a;
        head = 0;
        tail = n;
    }

    private void allocateElements(int numElements) {
        elements = new Integer[calculateSize(numElements)];
    }

    /**
     * 为了保证数组的容量是2的次幂.
     * 因为%效率不如&高.
     *
     * @param numElements 指定的数组容量
     * @return 实际数组容量
     */
    private static int calculateSize(int numElements) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>> 1);
            initialCapacity |= (initialCapacity >>> 2);
            initialCapacity |= (initialCapacity >>> 4);
            initialCapacity |= (initialCapacity >>> 8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0)   // Too many elements, must back off
            {
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
            }
        }
        return initialCapacity;
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(Integer k) {
        allocateElements(k);
    }

    /**
     * elements.length - 1 当做掩码使用
     * 例如 (0-1) & (8-1) = 7
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(Integer value) {
        if (value == null) {
            throw new NullPointerException();
        }
        elements[head = (head - 1) & (elements.length - 1)] = value;
        if (head == tail) {
            doubleCapacity();
        }
        return true;
    }

    /**
     * 1 & (8-1) = 1
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(Integer value) {
        if (value == null) {
            throw new NullPointerException();
        }
        elements[tail] = value;
        if ((tail = (tail + 1) & (elements.length - 1)) == head) {
            doubleCapacity();
        }
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        int h = head;
        Integer result = elements[h];
        if (result == null) {
            throw new NullPointerException();
        }
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        int t = (tail - 1) & (elements.length - 1);
        Integer result = elements[t];
        if (result == null) {
            throw new NullPointerException();
        }
        elements[t] = null;
        tail = t;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        Integer element = elements[head];
        if (element == null) {
            return -1;
        }
        return element;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        Integer result = elements[(tail - 1) & (elements.length - 1)];
        if (result == null) {
            return -1;
        }
        return result;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        boolean b = circularDeque.insertLast(1);// 返回 true
        boolean b1 = circularDeque.insertLast(2);// 返回 true
        boolean b2 = circularDeque.insertFront(3);// 返回 true
        boolean b3 = circularDeque.insertFront(4);// 已经满了，返回 false
        int rear = circularDeque.getRear();// 返回 2
        boolean b4 = circularDeque.deleteLast();// 返回 true
        boolean b5 = circularDeque.insertFront(4);// 返回 true
        int front = circularDeque.getFront();
        System.out.println("front = " + front);

    }
}
