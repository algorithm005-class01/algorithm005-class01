class Solution {
    /**
     * 思路：本题主要应用的是并查集相关的知识，实现一个并查集，然后同一个朋友圈的合并到一起
     * 这里的并查集除了基本实现外，还有路径压缩的处理
     */
    class UnionFind {
        private int count;
        private int[] parant;
        int[] size;

        public UnionFind(int n) {
            count = n;
            parant = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parant[i] = i;
                size[i] = 1;
            }
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            while (parant[x] != x) {
                parant[x] = parant[parant[x]];
                x = parant[x];
            }
            return x;
        }

        public void union(int p, int q) {
            int rootp = find(p);
            int rootq = find(q);
            if (rootp != rootq) {
                if (size[rootp] <= size[rootq]) {
                    parant[rootp] = rootq;
                    size[rootq] += size[rootp];
                }else {
                    parant[rootq] = rootp;
                    size[rootp] += size[rootq];
                }

                count--;
            }
        }


    }

    public int findCircleNum(int[][] M) {
        if (M == null) return 0;
        int length = M.length;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        return unionFind.getCount();
    }
}