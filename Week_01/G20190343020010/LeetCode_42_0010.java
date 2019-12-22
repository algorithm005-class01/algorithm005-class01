package miui.browser.db;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import miui.browser.util.Log;

/**
 * xiezhilin
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_42_0010 {

    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);

        for (int i = 1; i <= max; i++) {
            boolean check = false;
            int tempSum = 0;
            for (int j = 0; j < height.length; j++) {
                if (check && height[j] < i) {
                    tempSum++;
                }
                if (height[j] >= i) {
                    sum += tempSum;
                    tempSum = 0;
                    check = true;
                }
            }

        }

        return sum;
    }

    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
        }
        return max;
    }


    //讲实话，一脸蒙蔽，看了好几遍没看懂；
    // public int trap(int[] height) {
    //     int sum = 0 ;
    //     Stack<Integer> stack = new Stack<Integer>();
    //     int current = 0;

    //     while(current < height.length){
    //         while(!stack.empty() && height[current] > height[stack.peek()]){
    //             int value = height[stack.peek()];
    //             stack.pop();
    //             if(stack.empty()){
    //                 break;
    //             }
    //             int distance = current - stack.peek() -1;
    //             int min = Math.min(height[stack.peek()], height[current]);
    //             sum += distance * (min -value);
    //         }
    //         stack.push(current);
    //         current++;
    //     }
    //     return sum;
    // }
}
