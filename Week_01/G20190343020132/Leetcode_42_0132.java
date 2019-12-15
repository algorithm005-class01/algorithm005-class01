package org.azai.train.Week01;

import java.util.Stack;

public class Leetcode_42_0132 {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < height.length;i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (!stack.isEmpty()) {
                    sum += (Math.min(height[i],height[stack.peek()])-height[top]) * (i-stack.peek()-1);
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
