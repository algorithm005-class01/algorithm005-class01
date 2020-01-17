// [1,0,0,1],
// [0,1,1,0],
// [0,1,1,1],
// [1,0,1,1]
//预期结果是1

class Solution {

    public int findCircleNum(int[][] M) {
        int m = M != null ? M.length : 0;

        UnionFind uf = new UnionFind(m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        
        return uf.count();
    }



    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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

// 官方题解方案， 1ms
// class Solution {
//     int[] dx = {0, 1, 0, -1};
//     int[] dy = {1, 0, -1, 0};
//     public int findCircleNum(int[][] M) {
//         int count = 0;
//         int m = M != null ? M.length : 0, n = m > 0 ? M[0].length : 0;
//         int[] visited = new int[m];
//         for (int i = 0; i < m; i++) {
//             if (visited[i] == 0) {
//                 dfs(M, visited, i, n);
//                 count++;
//             }
//         }
//         return count;
//     }

//     private void dfs(int[][] M, int[] visited, int i, int n) {
//         for (int j = 0; j < n; j++) {
//             if (M[i][j] == 1 && visited[j] == 0) {
//                 visited[j] = 1;
//                 dfs(M, visited, j, n);
//             }
//         }
//     }

// }