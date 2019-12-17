// ============作业是参考题解，理解题解的思路后写的================

//理解：
// 1.当前高度小于等于栈顶高度、入栈，指针后移
// 2.当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，
//   然后计算当前的高度和新栈的高度的关系，重复第2步。直到当前墙的高
//   度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移

  class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;

        while (current < height.length) {
            //如果栈不为空且当前要入栈的元素大于栈顶的元素则循环
            while (!stack.empty() && height[current] > height[stack.peek()]) { //如果当前要入栈的元素比栈顶元素大
                int h = height[stack.peek()]; //记录要出栈的元素
                stack.pop();
                if (stack.empty()) //说明没有左边墙
                    break;
                int distance = current - stack.peek() - 1; //两堵墙之间的距离
                int min = Math.min(height[stack.peek()],height[current]);
                sum = sum + distance * (min - h);
            }

            stack.push(current); //记录当前入栈的墙的指针
            current++;
        }
        
        return sum;
    }
}