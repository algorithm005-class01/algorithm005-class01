class MyCircularDeque {
    
    
    var size = 0
    var array :[Int]
    
    var head = 0
    var tail = 0

    /** Initialize your data structure here. Set the size of the deque to be k. */
    init(_ k: Int) {
        size = k + 1
        array = Array.init(repeating: -1, count: size)
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    func insertFront(_ value: Int) -> Bool {
        if(isFull()){
            return false
        }
        
        head = (head - 1  + size) % size
        
        array[head] = value
        return true
        
        
        
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    func insertLast(_ value: Int) -> Bool {
        if(isFull()){
         return false
        }
        
        array[tail] = value
        tail = (tail + 1) % size
        
        return true
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    func deleteFront() -> Bool {
        if(isEmpty()){
            return false
        }
        
        head = (head + 1) % size
        return true
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    func deleteLast() -> Bool {
        if(isEmpty()){
                   return false
        }
        
        tail = (tail - 1 + size) % size
        
        return true
        
        
    }
    
    /** Get the front item from the deque. */
    func getFront() -> Int {
        if(isEmpty()){
            return -1
        }
        return array[head]
    }
    
    /** Get the last item from the deque. */
    func getRear() -> Int {
        if( isEmpty()){
            return -1
        }
        return array[(tail - 1 + size) % size]
    }
    
    /** Checks whether the circular deque is empty or not. */
    func isEmpty() -> Bool {
        return head == tail
    }
    
    /** Checks whether the circular deque is full or not. */
    func isFull() -> Bool {
        
        return (tail + 1) % size == head
       
        
    }
}