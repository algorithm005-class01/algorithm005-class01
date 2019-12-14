class MyCircularDeque {

    private Node head = null;
    private int capacity;
    private int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (head == null) {
            head = new Node(value, null, null);
            head.prev = head;
            head.next = head;
        }else {
            Node node = new Node(value, head, head.prev);
            head.prev.next = node;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (head == null) {
            head = new Node(value, null, null);
            head.prev = head;
            head.next = head;
        }else {
            Node node = new Node(value, head, head.prev);
            head.prev.next = node;
            head.prev = node;
        }
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            Node next = head.next;
            head.prev = null;
            head.next = null;
            head = next;
        }
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = null;
        }else {
            Node del = head.prev;
            head.prev = del.prev;
            del.prev.next = head;
            del.prev = null;
            del.next = null;
            del = null;
        }
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty()? -1 : head.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty()? -1 : head.prev.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    class Node{
        int value;
        Node next;
        Node prev;

        Node(int v, Node n, Node p) {
            value = v;
            next = n;
            prev = p;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */