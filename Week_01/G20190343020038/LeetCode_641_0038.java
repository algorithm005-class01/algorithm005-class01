class MyCircularDeque {

    private int k;
    private int size;
    // 设置 head 头结点
    private DoubleListNode head;
    // 设置 tail 尾结点
    private DoubleListNode tail;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = new DoubleListNode(-1);
        tail = new DoubleListNode(-1);
        head.pre = tail;
        tail.next = head;
        this.k = k;
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == k) {
            // 当前队列已满
            return false;
        }
        // 添加到第一个结点，即添加的 node 要在 head 前
        // node 的 next 指向 head
        // node 的 pre 指向 head.pre
        // head 的前一个结点指向 node，head.pre.next -> node
        // head 的 pre 指向 node
        DoubleListNode node = new DoubleListNode(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == k) {
            // 当前队列已满
            return false;
        }
        // 添加到最后一个结点，即添加的 node 要在 tail 后
        // node 的 next 指向 tail.next
        // tail 的后一个结点指向 node，tail.next.pre -> node
        // tail 的 next 指向 node
        // node 的 pre 指向 tail
        DoubleListNode node = new DoubleListNode(value);
        node.next = tail.next;
        tail.next.pre = node;
        tail.next = node;
        node.pre = tail;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        // 删除第一个
        // 及更改 head 与 head.pre.pre 的结点
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        // 删除最后一个
        // 及更改 tail 与 tail.next.next 的结点
        tail.next.next.pre = tail;
        tail.next = tail.next.next;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.pre.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.next.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k;
    }
}

class DoubleListNode {
    DoubleListNode pre;
    DoubleListNode next;
    int val;

    public DoubleListNode(int val) {
        this.val = val;
    }
}