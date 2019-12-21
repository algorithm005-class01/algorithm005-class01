class MyCircularDeque {

    private int[] arr;
    private int size; //当前大小
    private int capacity; //总大小
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.arr = new int[k];
        this.size = 0;
        this.capacity = k;
        this.head = 0;
        this.tail = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        //首先判断是否满
        if (isFull()) {
            return false;
        }
        head = (head + capacity - 1) % capacity;
        arr[head] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[tail] = value;
        tail = (tail + capacity + 1) % capacity;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail + capacity - 1) % capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(tail - 1 + capacity) % capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail && size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return head == tail && size == capacity;
    }
}