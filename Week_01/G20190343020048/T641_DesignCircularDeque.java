package main.leetcode_solutions.queue;

/**
 * 实现循环双端队列：
 * 两种实现方式：
 * 1)数组 T641_DesignCircularDeque
 * 2)双向循环链表 T641_DesignCircularDeque2
 * @author wenzhuang
 * @date 2019-12-15
 */

/**
 * 数组实现
 */
public class T641_DesignCircularDeque {
    private int[] items;
    private int head;
    private int tail;
    private int count;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public T641_DesignCircularDeque(int k) {
        items = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        head = (head + items.length - 1) % items.length;
        items[head] = value;
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        items[tail] = value;
        tail = (tail + 1) % items.length;
        count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        head = (head + 1) % items.length;
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        tail = (tail + items.length - 1) % items.length;
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return items[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        int pos = (tail + items.length - 1) % items.length;
        return items[pos];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return head == tail && count > 0;
    }
}
