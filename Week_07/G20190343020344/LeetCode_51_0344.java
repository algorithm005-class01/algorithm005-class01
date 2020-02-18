/*
* 51. N皇后
* 困难
*
* n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* */



/**
 * @author GaoK
 * @date 2020/02/16
 */
public class LeetCode_51_0344 {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, res, new ArrayList<String>(), col, z_diagonal, f_diagonal);
        return res;


    }

    private void backtrack(int i, int n, List<List<String>> res, ArrayList<String> tmp, Set<Integer> col, Set<Integer> z_diagonal, Set<Integer> f_diagonal) {
        if (i == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !z_diagonal.contains(i + j) && !f_diagonal.contains(i - j)) {
                col.add(j);
                z_diagonal.add(i + j);
                f_diagonal.add(i - j);
                char[] s = new char[n];
                Arrays.fill(s, '.');
                s[j] = 'Q';
                tmp.add(new String(s));
                backtrack(i+1,n,res,tmp,col,z_diagonal,f_diagonal);
                tmp.remove(tmp.size() - 1);
                col.remove(j);
                z_diagonal.remove(i + j);
                f_diagonal.remove(i - j);
            }
        }
    }
}