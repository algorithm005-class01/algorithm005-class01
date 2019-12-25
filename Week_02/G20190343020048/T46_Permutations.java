package main.leetcode_solutions.recursion;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/21
 */
public class T46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backtrack(0, nums, res, item);
        return res;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> item){
        if (item.size() == nums.length){
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < nums.length; i++){
            exch(nums, start, i);
            item.add(nums[start]);
            backtrack(start + 1, nums, res, item);
            exch(nums, start, i);
            item.remove(item.size() - 1);
        }
    }

    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
