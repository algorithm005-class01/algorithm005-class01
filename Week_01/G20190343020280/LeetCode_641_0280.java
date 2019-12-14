class MyCircularDeque {

    private int size;
    private int maxSize;
    private Node first;
    private Node last;


    class Node {
        int val;
        Node prev;
        Node next;
        public Node (int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        maxSize = k;
        first = new Node(0);
        last = new Node(-1);
        first.next = last;
        last.prev = first;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size>=maxSize) {
            return false;
        }
        Node node = new Node(value);
        Node next = first.next;
        node.prev = first;
        first.next = node;
        node.next = next;
        next.prev = next;
        size++;
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size>=maxSize) {
            return false;
        }
        Node node = new Node(value);
        Node prev = last.prev;
        node.next = last;
        last.prev = node;
        prev.next = node;
        node.prev = prev;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size==0) {
            return false;
        }
        Node delete = first.next;
        Node next = delete.next;
        first.next = next;
        next.prev = first;
        delete.prev = null;
        delete.next = null;
        size--;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size==0) {
            return false;
        }
        Node delete = last.prev;
        Node prev = delete.prev;
        last.prev = prev;
        prev.next = last;
        delete.prev = null;
        delete.next = null;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size==0) {
            return -1;
        } else {
            return first.next.val;
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size==0) {
            return -1;
        } else {
            return last.prev.val;
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==maxSize;
    }
}