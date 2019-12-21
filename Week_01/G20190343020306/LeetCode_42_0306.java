class Solution {
    public int trap(int[] height) {
        //初始化一个栈
        Stack<Integer> stack = new Stack<>();

        int waterCapacity = 0;
        int tbd = 0;
        int leftHighest = 0;
        
        for (int i = 0; i < height.length; i++) {
            //判断栈顶高度与当前的柱子高度比较
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int h = stack.peek();
                //出栈
                stack.pop();
                if (stack.empty()) {
                    break; //如果栈里面就一个元素, 说明紧挨着, 不可能盛水
                }
                //取下一个栈顶, 此时这个栈顶高度>=当前栈顶高度，中间正好是一个容器
                int min = Math.min(height[i], height[stack.peek()]);
                int distance = i - stack.peek() - 1;
                waterCapacity += (min - height[h]) * distance;
            }
            
            stack.push(i);
          
        }
        return waterCapacity;
    }
}