// 我这版的并查集实现的很简单，只进行了压缩，未进行平衡，这个算法性能也不怎样，执行需要5ms，比着下沉实现慢多了
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid == null ? 0 : grid.length, n = m == 0? 0 : grid[0].length;

        UnionFind uf = new UnionFind(grid, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    // 只用判断右和下面即可
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + (j + 1));
                    }
                }
            }
        }

        return uf.count();
    }

    class UnionFind{
        private int[] parent;
        private int count;

        public UnionFind(char[][] grid, int m, int n) {
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            parent[rootP] = rootQ;
            count--;
        }

        private int find(int p) {
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public int count() {
            return count;
        }
    }
}