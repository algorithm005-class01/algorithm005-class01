class MyCircularDeque {
    private:
    vector<int> queue;
    int front;
    int rear;
    int maxSize;
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) 
    {
        front = 0;
        rear = 0;
        maxSize = k+1;
        queue = vector<int>(maxSize,-1);
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        
        if(isFull())  
            return false;
        queue[front] = value;
        front = (front - 1 + maxSize)%maxSize;//队头前移，实现循环效果
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) 
    {
        if(isFull())
            return false;
       
        rear = (rear + 1)%maxSize;//队尾后移动且可以防止越界
        queue[rear] = value;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(isEmpty())
            return false;
        front = (front+1)%maxSize;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(isEmpty())
            return false;
        rear = (rear-1+maxSize)%maxSize;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if(isEmpty())
            return -1;
        return queue[(front+1)%maxSize];//为什么要这么写？
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if(isEmpty())
            return -1;
        return queue[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        if(rear == front)
            return true;
        return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        if((rear+1)%maxSize == front)
            return true;
        return false;
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */