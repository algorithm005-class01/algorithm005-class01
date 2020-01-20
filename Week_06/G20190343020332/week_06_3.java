class Solution {

    public int find(int[] parent, int i){
        if(parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int i, int j){
        int pi = find(parent, i);
        int pj = find(parent, j);
        if(pi != pj){
            parent[pi] = pj;
        }
    }

    public int findCircleNum(int[][] M) {
        int m = M.length;
        if(m == 0)
            return 0;
        int[] parent = new int[m];
        Arrays.fill(parent, -1);
        for(int i = 0; i < m - 1; i++)
            for(int j = i + 1; j < m; j++){
                if(M[i][j] == 1)
                    union(parent, i, j);
            }
        
        int count  = 0;
        for(int i = 0; i < m; i++){
            if(parent[i] == -1)
                count++;
        }
        return count;
    }

    
}