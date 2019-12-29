class MyCircularDeque {
    int[] deque;
    int head;
    int tail;
    int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        head = tail = k / 2;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            deque[head] = value;
        }
        else if (head == 0) {
            //  move right
            for (int i = tail + 1; i > head; --i)
                deque[i] = deque[ i - 1];
            deque[head] = value;
            ++ tail;
        }
        else 
            deque[--head] = value;
        ++ size;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            deque[tail] = value;
        }
        else if (tail == deque.length - 1) {
            //  move left
            for (int i = head - 1; i < tail; ++i)
                deque[i] = deque[ i + 1];
            deque[tail] = value;
            -- head;
        }
        else 
            deque[++tail] = value;
        ++ size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        deque[head] = 0;
        -- size;
        if (isEmpty())
            head = tail = deque.length / 2; 
        else 
            ++ head;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        deque[tail] = 0;
        -- size;
        if (isEmpty())
            head = tail = deque.length / 2;
        else
            -- tail;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : deque[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : deque[tail];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == deque.length;
    }
}