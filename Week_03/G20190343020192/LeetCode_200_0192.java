public class LeetCode_200_0192 {
    // 200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/solution/

    /*
    解法
    1. 从第一个点[0][0]开始（第一层），第一次遇到1的时候岛数量+1
    2. 上下左右开始遍历：（第二层）
      2.1. 遇到1，把该节点变0，并根据对改点进行递归，重复步骤2
      2.2. 遇到0，结束本次循环
    3. 遍历剩下节点（第一层）
     */

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
