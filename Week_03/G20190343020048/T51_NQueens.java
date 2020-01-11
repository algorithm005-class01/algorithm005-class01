package main.leetcode_solutions.backtracking;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/29
 */
public class T51_NQueens {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> sum = new HashSet<>();
        Set<Integer> sub = new HashSet<>();
        dfs(0, n, path, paths, cols, sum, sub);
        return print(paths, n);
    }

    private void dfs(int i, int n, List<Integer> path, List<List<Integer>> paths, Set<Integer> cols, Set<Integer> sum, Set<Integer> sub){
        if (i == n){
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < n; j++){
            if (!cols.contains(j) && !sum.contains(i + j) && !sub.contains(i - j)){
                path.add(j);
                cols.add(j);
                sum.add(i + j);
                sub.add(i - j);
                dfs(i + 1, n, path, paths, cols, sum, sub);
                path.remove(path.size() - 1);
                cols.remove(j);
                sum.remove(i + j);
                sub.remove(i - j);
            }
        }
    }

    private List<List<String>> print(List<List<Integer>> paths, int n){
        List<List<String>> res = new ArrayList<>();
        String ori = "";
        for (int i = 0; i < n; i++){
            ori += ".";
        }
        for (int i = 0; i < paths.size(); i++){
            List<String> sol = new ArrayList<>();
            for (int j = 0; j < paths.get(i).size(); j++){
                sol.add(ori.substring(0, paths.get(i).get(j)) + "Q" + ori.substring(paths.get(i).get(j) + 1));
            }
            res.add(sol);
        }
        return res;
    }
}
