// 针对这道题，并查集可以做为一个解决方案，但是相对还是太慢
class Solution {
    public void solve(char[][] board) {
        int m = board == null ? 0 : board.length, n = m == 0 ? 0 : board[0].length;

        int dummyNode = m * n;

        UnionFind uf = new UnionFind(dummyNode + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int node = node(i, j, n);
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        uf.union(node, dummyNode);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') {
                            uf.union(node, node(i - 1, j, n));
                        } 
                         if (j > 0 && board[i][j - 1] == 'O') {
                            uf.union(node, node(i, j - 1, n));
                        }
                        if (i + 1 < m && board[i + 1][j] == 'O') {
                            uf.union(node, node(i + 1, j, n));
                        } 
                        if (j + 1 < n && board[i][j + 1] == 'O') {
                            uf.union(node, node(i, j + 1, n));
                        } 
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (uf.find(dummyNode) != uf.find(node(i, j, n))) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private int node(int i, int j, int n) {
        return i * n + j;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
        }

        public int find(int p) {
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}