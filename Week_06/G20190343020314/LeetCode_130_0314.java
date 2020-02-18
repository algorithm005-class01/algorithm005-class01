package week06;

/**
 * Description: 被围绕的区域.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_130_0314 {
  class Solution {
    public void solve(char[][] board) {
      
      if (board == null || board.length == 0) return;
      
      int rows = board.length;
      int cols = board[0].length;
      
      UnionFind uf = new UnionFind(rows * cols + 1);
      int dummyNode = rows * cols;
      
      for (int i = 1; i < rows-1; i++) {
        for (int j = 1; j < cols-1; j++) {
          if (board[i][j] == 'O') {
            if (board[i - 1][j] == 'O')
              uf.union(i*cols+j, (i-1)*cols+j);
            if (board[i + 1][j] == 'O')
              uf.union(i*cols+j, (i+1)*cols+j);
            if (board[i][j - 1] == 'O')
              uf.union(i*cols+j, i*cols+j-1);
            if (board[i][j + 1] == 'O')
              uf.union(i*cols+j, i*cols+j+1);
          }
        }
      }
      
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (board[i][j] == 'O') {
            if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
              uf.union(cols*i+j, dummyNode);
            }
          }
        }
        
      }
      
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          //System.out.println("["+i+","+j+"]"+uf.find(cols*i+j));
          if (uf.find(cols*i+j)==dummyNode) {
            board[i][j] = 'O';
          } else {
            board[i][j] = 'X';
          }
        }
      }
      
    }
  }
  
  class UnionFind {
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }
    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }
    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) return;
      parent[rootP] = rootQ;
      count--;
    }
  }
}
