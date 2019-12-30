package main.leetcode_solutions.greedy;

/**
 * @author wenzhuang
 * @date 2019/12/29 9:38 PM
 */
public class T55_JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0, index = 0;
        while (index <= max){
            int cur = index + nums[index];
            if (cur >= nums.length - 1){
                return true;
            }
            max = Math.max(max, cur);
            index++;
        }
        return false;
    }
}
