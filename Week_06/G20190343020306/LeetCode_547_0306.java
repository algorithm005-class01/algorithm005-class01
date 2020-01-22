class Solution {
    public int findCircleNum(int[][] M) {
        //先将自身建立独立集合
        Union union = new Union(M.length);

        //遍历M矩阵
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) { //对称矩阵, 只需要遍历一半即可
                if (M[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }

        return union.getCount();
    }
}

class Union {
    private int count;
    private int[] parent;

    public int getCount() {
        return count;
    }

    public Union(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; //路径压缩
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) {
            return; //同一个集合不合并
        }
        parent[rootq] = rootp;
        count--;
    }
}