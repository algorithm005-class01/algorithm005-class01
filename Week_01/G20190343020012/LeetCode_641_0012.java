public class Solution641 {
  private int front;
  private int rear;
  private int size;
  private final int capacity;
  private int[] data;

  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public Solution641(int capacity) {
    front = 0;
    rear = 0;
    size = 0;
    this.capacity = capacity;
    data = new int[capacity];
  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    front = (front - 1 + capacity) % capacity;
    data[front] = value;
    size++;
    return true;
  }

  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    data[rear] = value;
    rear = (rear + 1 + capacity) % capacity;
    size++;
    return true;
  }

  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    front = (front + 1 + capacity) % capacity;
    size--;
    return true;
  }

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    rear = (rear - 1 + capacity) % capacity;
    size--;
    return true;
  }

  /**
   * Get the front item from the deque.
   */
  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return data[front];
  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }

    return data[(rear - 1 + capacity) % capacity];
  }

  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    return front == rear && size == 0;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    return front == rear && size == capacity;
  }

}
