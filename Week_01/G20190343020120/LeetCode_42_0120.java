class Solution {
    public int trap(int[] height) {
        int sum=0;
        //stack中存放的是数组索引
        Stack<Integer> stack = new Stack<Integer>();
        int current=0;
        while(current<height.length){
            //当height[current]>stack.peek()时进行逻辑处理
            while(!stack.isEmpty()&&height[current]>height[stack.peek()]){
                int h=height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int distance=current-stack.peek()-1;
                int min=Math.min(height[current],height[stack.peek()]);
                sum+=distance*(min-h);
            }
            //在height[current]<stack.peek()的时候会直接入栈
            stack.push(current);
            current++;
        }
        return sum;
    }
}