头插和尾插是反向的，一定要注意这一点
四个关键语句，在取模下队列就是循环的

尾插 arr[rear] =val; rear = (rear+1)% capacity;
头插 front = (front -1 +capacity) % capacity; arr[front] =val; 因为对于头节点来说，最开始是和尾节点一样处于队尾位置的，从队头插就意味着要插在头节点（所以-1再插）
空: rear == front;
满: (rear+1)%capacity == front; 记住这四个条件

pop的时候就是按照相关的顺序进行反向
尾出: val = arr[(rear - 1 +capacity)%capacity]//防止溢出，减法时取模保证时时为正;//处理完之后队尾的变量要移位处理，所以取出时要先反向处理再取
头出: val = arr[front];//每次赋的时候都是处理完移位后赋的，所以取的时候不用动


class MyCircularDeque {
    private:
    int front,rear;
    vector <int> arr;
    int capacity;
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capacity = k+1;
        arr.assign(capacity,0); // 初始化赋值?

        front=0;rear=0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front - 1 + capacity) % capacity; //为什么头插是-1再取模？
        arr[front] = value;             
        return true;   
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(isFull()){
            return false;
        }
        arr[rear] = value;
        rear = (rear+1) %capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front +1) % capacity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if(isEmpty()){
          return -1;
          }
        return arr[front];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(rear - 1 + capacity)%capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return front == rear;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return (rear+1)%capacity == front;         
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

