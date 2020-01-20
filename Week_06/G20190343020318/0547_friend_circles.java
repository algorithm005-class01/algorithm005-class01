class Solution {
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
        }
            
        public int count() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] M) {
        if(M == null) return 0;
        int m = M.length;
        int n;
        if(M[0] != null) {
            n = M[0].length;
        }else {
            return 0;
        }
        
        boolean visited[] = new boolean[m];
        int count = 0;
        
        for(int i = 0; i < m; ++i) {
            if(!visited[i]) {
                dfs(M, visited, i);
                ++ count;
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] M, boolean visited[], int i) {
        for(int j = 0; j < M[0].length; ++j) {
            if(M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}