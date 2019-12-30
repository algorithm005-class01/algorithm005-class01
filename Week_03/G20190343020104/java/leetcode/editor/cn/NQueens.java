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
        Set<Integer> cols = new HashSet<>();//之前皇后攻击的位置
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        public List<List<String>> solveNQueens(int n) {
            List<String> list = new ArrayList<>();
            dfs(n, 0, list);
            return result;

        }

        private void dfs(int n, int row, List<String> state) {
            //terminator
            if (row >= n) {
                result.add(state);
                return;
            }
            for (int i = 0; i < n; i++) {
                //列是否已有皇后
                boolean queExist = cols.contains(i);
                boolean pieExist = pie.contains(row + i);
                boolean naExist = na.contains(row - i);
                if (queExist || pieExist || naExist) {
                    continue;
                }
                cols.add(i);
                pie.add(row + i);
                na.add(row - i);
                state.add(String.valueOf(i));
                dfs(n, row + 1, state);
                cols.remove(i);
                pie.remove(row + i);
                na.remove(row - i);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}