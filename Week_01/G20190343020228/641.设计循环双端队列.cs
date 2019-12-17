/*
 * @lc app=leetcode.cn id=641 lang=csharp
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
public class MyCircularDeque {

    private int[] myqueue;
    private int head;
    private int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        myqueue = new int[k];
        head=0;
        size=0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public bool InsertFront(int value) {
        if(IsFull()) return false;
        head = (head+myqueue.Length-1)%myqueue.Length;
        myqueue[head]=value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public bool InsertLast(int value) {
        if(IsFull()) return false;
        myqueue[(head+size)%myqueue.Length]=value;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public bool DeleteFront() {
        if(IsEmpty()) return false;
        head = (head+1)%myqueue.Length;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public bool DeleteLast() {
        if(IsEmpty()) return false;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int GetFront() {
        return size!=0?myqueue[head]:-1;
    }
    
    /** Get the last item from the deque. */
    public int GetRear() {
        return size != 0 ? myqueue[(head + size - 1) % myqueue.Length] : -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public bool IsEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public bool IsFull() {
        return size==myqueue.Length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * bool param_1 = obj.InsertFront(value);
 * bool param_2 = obj.InsertLast(value);
 * bool param_3 = obj.DeleteFront();
 * bool param_4 = obj.DeleteLast();
 * int param_5 = obj.GetFront();
 * int param_6 = obj.GetRear();
 * bool param_7 = obj.IsEmpty();
 * bool param_8 = obj.IsFull();
 */
// @lc code=end

