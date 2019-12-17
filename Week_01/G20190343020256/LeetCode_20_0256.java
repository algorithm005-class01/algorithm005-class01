package Week0;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_20_0256 {
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && map.keySet().contains(stack.peek())) {
                if (map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;

                }
            }
            else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
