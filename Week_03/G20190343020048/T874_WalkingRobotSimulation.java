package main.leetcode_solutions.greedy;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/29 9:03 PM
 */
public class T874_WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, max = 0;
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles){
            set.add(obstacle[0] + " " + obstacle[1]);
        }
        for (int command : commands){
            if (command == -1){
                d = (d + 1) % 4;
            } else if (command == -2){
                d = (d + 3) % 4;
            } else {
                while (command-- > 0 && !set.contains((x + dir[d][0]) + " " + (y + dir[d][1]))){
                    x = x + dir[d][0];
                    y = y + dir[d][1];
                }
            }
            max = Math.max(max, x * x + y * y);
        }
        return max;
    }
}
