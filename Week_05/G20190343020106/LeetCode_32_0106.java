package Week05;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int lastError = -1;
        char[] array = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.add(i);
            } else if (array[i] == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                    int len;
                    if (stack.size() == 0) {
                        len = i - lastError;
                    } else {
                        len = i - stack.peek();
                    }
                    if (len > maxLen) {
                        maxLen = len;
                    }
                } else {
                    lastError = i;
                }
            }
        }
        return maxLen;
    }
}
