package org.bone.grow.week03;

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, n, col, pie, na, stack, res);

        return res;
    }

    // 循环每一行，每次确定一个坐标
    // 确定一个坐标的时候同时排除：
    //    1.对应的行
    //    2.对应的正斜边（pie）
    //    3.对应的反斜边（na）
    // 回溯的时候进行状态清理
    private void backtrack(int[] nums, int row, int n,
                           Set<Integer> col,
                           Set<Integer> pie,
                           Set<Integer> na,
                           Stack<Integer> stack,
                           List<List<String>> res) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !pie.contains(row + i) && !na.contains(row - i)) {
                stack.add(nums[i]);
                col.add(i);
                pie.add(row + i);
                na.add(row - i);

                backtrack(nums,row + 1, n, col, pie, na, stack, res);

                pie.remove(row + i);
                na.remove(row - i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();

        for (Integer num : stack) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            sb.replace(num, num + 1, "Q");
            board.add(sb.toString());
        }

        return board;
    }

    public static void main(String[] args) {
        System.out.print(new NQueens().solveNQueens(40));
    }
}
