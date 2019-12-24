package main.leetcode_solutions.recursion;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/21
 */
public class T47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backtrack(0, nums, res, item);
        return res;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> res, List<Integer> item){
        if (index == nums.length){
            res.add(new ArrayList<>(item));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++){
            if (set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            exch(nums, index, i);
            item.add(nums[index]);
            backtrack(index + 1, nums, res, item);
            exch(nums, index, i);
            item.remove(item.size() - 1);
        }
    }

    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
