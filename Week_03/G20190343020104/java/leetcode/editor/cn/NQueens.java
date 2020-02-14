//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            List<String> list = new ArrayList<>();
            Set<Integer> cols = new HashSet<>();//之前皇后占的位置
            Set<Integer> pie = new HashSet<>(); //撇的攻击范围
            Set<Integer> na = new HashSet<>();//捺的攻击范围
            dfs(n, 0, cols, pie, na, list);
            return result;

        }

        private void dfs(int n, int row, Set<Integer> cols, Set<Integer> pie, Set<Integer> na, List<String> state) {
            //terminator
            if (row >= n) {
                result.add(convert2board(state, n));
                return;
            }
            //看每一列是否可以放
            for (int col = 0; col < n; col++) {
                boolean queExist = cols.contains(col);
                boolean pieExist = pie.contains(row + col);
                boolean naExist = na.contains(row - col);
                if (queExist || pieExist || naExist) {
                    continue;
                }
                //做选择
                cols.add(col);
                pie.add(row + col);
                na.add(row - col);
                state.add(String.valueOf(col));
                System.out.println("row:" + row + " col:" + col + "" + ", pie:" + pie + ", na:" + na + ", state:" + state);

                //下探新的一层
                dfs(n, row + 1, cols, pie, na, state);

                //撤销选择
                cols.remove(col);
                pie.remove(row + col);
                na.remove(row - col);
                state.remove(col + "");
            }
        }

        private List<String> convert2board(List<String> stack, int n) {
            List<String> board = new ArrayList<>();
            for (String s : stack) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(".");
                }
                int num = Integer.valueOf(s);
                stringBuilder.replace(num, num + 1, "Q");
                board.add(stringBuilder.toString());
            }
            return board;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}