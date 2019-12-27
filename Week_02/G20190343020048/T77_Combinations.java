package main.leetcode_solutions.recursion;


import java.util.*;
/**
 * @author wenzhuang
 * @date 2019-10-03
 */
/**
 * 求组合数
 * dfs，回溯
 **/
public class T77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backtrack(1, n, k, res, item);
        return res;
    }

    private void backtrack(int start, int n, int k, List<List<Integer>> res, List<Integer> item){
        if (item.size() == k){
            res.add(new ArrayList<>(item));
            return;
        }
        if (k - item.size() + start - 1 > n){
            return;
        }
        for (int i = start; i <= n; i++){
            item.add(i);
            backtrack(i + 1, n, k, res, item);
            item.remove(item.size() - 1);
        }
    }
}
