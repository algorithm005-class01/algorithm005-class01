package G20190343020064;

import java.util.Map;
import java.util.Stack;

/**
 * <p>
 * description
 * </p>
 *
 * @author mingke  2019-12-14 7:39 下午
 */
public class LeetCode_42_0064 {


    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            //===============================================================================
            //  当出现 当前位置高度 大于 上一个位置高度时，往前计算水量
            //===============================================================================
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //  当前要计算水量的高度 并出栈，后续继续往前寻找
                int currentHeight = height[stack.pop()];
                //===============================================================================
                //  当栈下一个元素为空时 则无需后续计算
                //===============================================================================
                if (stack.empty()) {
                   break;
                }
                // 两个墙之间的能盛水高度
                int h = Math.min(height[stack.peek()],height[i]) - currentHeight;
                // 两个墙的距离
                int l = i - stack.peek() - 1;
                water += h * l;
            }
            stack.push(i);
        }
        return water;
    }


}
