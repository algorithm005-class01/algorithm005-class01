
/**
 * @Author huangxiong
 * @Date 2019/12/12
 * @Description leetcode 题目641
 **/
public class LeetCode_641_0110 {
    private int[] data;
    /*队头指针*/
    private int front;
    /*队尾指针*/
    private int last;
    /*队列当前的大小*/
    private int size;
    /*队列的容量*/
    private int length;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public LeetCode_641_0110(int k) {
        this.data = new int[k];
        this.front = 0;
        this.length = 0;
        this.size = 0;
        this.length = k;
    }

    //将一个元素添加到双端队列头部。 如果操作成功返回 true。

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        //如果队列满，插入失败
        if (isFull()) return false;
        front = (front + length - 1) % length;
        data[front] = value;
        size++;
        return true;
    }

    //将一个元素添加到双端队列尾部。如果操作成功返回 true。

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        /*如果队列满，插入失败*/
        if (isFull()) return false;
        data[last] = value;
        last = (last + 1 + length) % length;
        size++;
        return true;

    }

    //从双端队列头部删除一个元素。 如果操作成功返回 true。

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % length;
        size--;
        return true;

    }

    //从双端队列尾部删除一个元素。如果操作成功返回 true。

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        last = (last - 1 + length) % length;
        size--;
        return true;
    }

    //从双端队列头部获得一个元素。如果双端队列为空，返回 -1。

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return data[front];
    }

    //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return data[(last - 1 + length) % length];
    }

    //检查双端队列是否为空。

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return (last == front) && size==0;
    }

    // 检查双端队列是否满了。

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return last == front && size == length;
    }
}
