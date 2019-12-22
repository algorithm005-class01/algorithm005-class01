package com.kawo.algorithm.code.weeka.util

internal class Deque(k: Int) {
    var myqueue: IntArray
    private var front: Int
    private var rear: Int
    var size: Int
    var capacity: Int


    fun insertFront(value: Int): Boolean {
        return if (rear == front && size == capacity) false //如果队列满，插入失败
        else {
            front = (front + capacity - 1) % capacity
            myqueue[front] = value
            size++
            true
        }
    }


    fun insertLast(value: Int): Boolean {
        return if (rear == front && size == capacity) false //如果队列满，插入失败
        else {
            myqueue[rear] = value
            rear = (rear + 1 + capacity) % capacity
            size++
            true
        }
    }


    fun deleteFront(): Boolean {
        return if (rear == front && size == 0) false else {
            front = (front + 1) % capacity
            size--
            true
        }
    }


    fun deleteLast(): Boolean {
        return if (rear == front && size == 0) false else {
            rear = (rear - 1 + capacity) % capacity
            size--
            true
        }
    }


    fun getFront(): Int {
        return if (rear == front && size == 0) -1 else {
            myqueue[front]
        }
    }


    fun getRear(): Int {
        return if (rear == front && size == 0) -1 else {
            myqueue[(rear - 1 + capacity) % capacity]
        }
    }

    /** Checks whether the circular deque is empty or not.  */
    val isEmpty: Boolean
        get() = rear == front && size == 0

    /** Checks whether the circular deque is full or not.  */
    val isFull: Boolean
        get() = rear == front && size == capacity

    /** Initialize your data structure here. Set the size of the deque to be k.  */
    init {
        myqueue = IntArray(k)
        front = 0
        rear = 0
        size = 0
        capacity = k
    }
}

