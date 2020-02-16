import java.util.Stack;

public class LeetCode_84_0082 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.peek() == -1 || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                    Integer pop = stack.pop();
                    max = Math.max(max, (i - stack.peek() - 1) * heights[pop]);
                }
                stack.push(i);
            }
        }
        while (stack.peek() != -1) {
            Integer pop = stack.pop();
            max = Math.max(max, (heights.length - stack.peek() - 1) * heights[pop]);
        }
        return max;
    }

}
