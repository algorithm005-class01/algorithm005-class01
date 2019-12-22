package com.kawo.algorithm.code.weeka.util

import java.util.*


internal class MinStack {
    private val stack: Stack<Int> = Stack()
    private val min_stack: Stack<Int> = Stack()
    fun push(x: Int) {
        stack.push(x)
        if (min_stack.isEmpty() || x <= min_stack.peek()) min_stack.push(x)
    }

    fun pop() {
        if (stack.pop() == min_stack.peek()) min_stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    val min: Int
        get() = min_stack.peek()

}