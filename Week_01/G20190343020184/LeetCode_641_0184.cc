class MyCircularDeque {

private:
    int front;
    int trail;
    int count;
    int* queue;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k)
    {
	front = 0;
	trail = 0;
	count = k + 1;
	queue = new int[k + 1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value)
    {
	if (isFull()) {
	    return false;
	}
	queue[front] = value;
	front = (front - 1 + count) % count;
	return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value)
    {
	if (isFull()) {
	    return false;
	}
	trail = (trail + 1) % count;
	queue[trail] = value;
	return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront()
    {
	if (isEmpty()) {
	    return false;
	}
	front = (front + 1) % count;
	return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast()
    {
	if (isEmpty()) {
	    return false;
	}
	trail = (trail - 1 + count) % count;
	return true;
    }

    /** Get the front item from the deque. */
    int getFront()
    {
	if (isEmpty()) {
	    return -1;
	}
	return queue[(front + 1) % count];
    }

    /** Get the last item from the deque. */
    int getRear()
    {
	if (isEmpty()) {
	    return -1;
	}
	return queue[trail];
    }

    /** Checks whether the circular deque is empty or not. */
    bool isEmpty()
    {
	if (trail == front) {
	    return true;
	}
	return false;
    }

    /** Checks whether the circular deque is full or not. */
    bool isFull()
    {
	if ((trail + 1) % count == (front) % count) {
	    return true;
	}
	return false;
    }
};
