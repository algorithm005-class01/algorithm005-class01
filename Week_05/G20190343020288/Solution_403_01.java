package week_05.commit;

import java.util.HashSet;
import java.util.Stack;

// 403. 青蛙过河
// https://leetcode-cn.com/problems/frog-jump/
public class Solution_403_01 {

    public boolean canCross(int[] stones) {
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2)
                return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int s : stones)
            set.add(s);
        Stack<Integer> stack_possition = new Stack<Integer>();
        stack_possition.push(0);
        Stack<Integer> stack_distance = new Stack<Integer>();
        stack_distance.push(0);
        int lastHop = stones[stones.length - 1];
        while (!stack_possition.isEmpty()) {
            int possition = stack_possition.pop();
            int distance = stack_distance.pop();
            for (int i = distance - 1; i <= distance + 1; i++) {
                if (i <= 0)
                    continue;
                int next_possition = i + possition;
                if (next_possition == lastHop)
                    return true;
                else if (set.contains(next_possition)) {
                    stack_possition.push(next_possition);
                    stack_distance.push(i);
                }
            }
        }
        return false;
    }
}
