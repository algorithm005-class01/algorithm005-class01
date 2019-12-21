class MyCircularDeque {
    Node first;
    Node last;
    int size;
    int nodeNumber = 0;

    class Node {
        Node post;
        Node prev;
        int value;

        Node(int value, Node prev, Node post) {
            this.value = value;
            this.prev = prev;
            this.post = post;
        }
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (nodeNumber == 0) {
            Node node = new Node(value, null, first);
            first = node;
            last = node;
            nodeNumber++;
            return true;
        } else if (nodeNumber < size) {
            Node node = new Node(value, null, first);
            first.prev = node;
            first = node;
            nodeNumber++;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (nodeNumber == 0) {
            Node node = new Node(value, null, null);
            first = node;
            last = node;
            nodeNumber++;
            return true;
        } else if (nodeNumber < size) {
            Node node = new Node(value, last, null);
            last.post = node;
            last = node;
            nodeNumber++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (nodeNumber != 0) {
            first = first.post;
            nodeNumber--;
            size0SetStatus();
            return true;
        } else {
            return false;
        }

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (nodeNumber != 0) {
            last = last.prev;
            nodeNumber--;
            size0SetStatus();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (first == null) {
            return -1;
        }
        return first.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (last == null) {
            return -1;
        }
        return last.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return nodeNumber == size;
    }

    private void size0SetStatus() {
        if (nodeNumber == 0) {
            first = null;
            last = null;
        }
    }
}