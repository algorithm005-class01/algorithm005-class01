class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for ( int i = 0; i < height.length; i++) {
            while( !stack.empty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.empty()) break;
                int h = Math.min(height[i], height[stack.peek()]);
                sum = sum + (h - height[top]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return sum;
    }
}