package main.leetcode_solutions.greedy;

/**
 * @author wenzhuang
 * @date 2019/12/29 11:12 PM
 */
public class T45_JumpGameII {
    public int jump(int[] nums) {
        int curEnd = 0, curFarthest = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++){
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd){
                step++;
                curEnd = curFarthest;
            }
        }
        return step;
    }
}
