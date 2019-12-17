class MyCircularDeque {
private:
	int front;		
	int rear;		
	int maxSize;	
	int *queue;		
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        queue = new int[k+1];	
		maxSize = k+1;			
		front = 0;				
		rear  = 0;				
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(isFull()){	
			return false;
		}else{
			queue[front] = value;				
			front = (front+maxSize-1)%maxSize;	
			return true;
		}
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(isFull()){	
			return false;
		}else{
			rear = (rear+1)%maxSize;	
			queue[rear] = value;		
			return true;
		}
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(isEmpty()){
			return false;
		}else{
			front = (front+1)%maxSize;		
			return true;
		}
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(isEmpty()){
			return false;
		}else{
			rear = (rear+maxSize-1)%maxSize;
			return true;
		}
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if(isEmpty())
			return -1;
		else  
			return queue[(front+1)%maxSize];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if(isEmpty())
			return -1;
		else  
			return queue[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        if( front == rear )	
			return true;
		else  
			return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        if( (rear+1)%maxSize == front )	
			return true;
		else  
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