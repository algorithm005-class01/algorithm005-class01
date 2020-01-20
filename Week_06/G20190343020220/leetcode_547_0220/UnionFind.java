package Week_06.G20190343020220.leetcode_547_0220;

/**
 * 并查集
 *
 * @author Darcy
 * @date 2020-01-15 10:21
 */
public class UnionFind {
    /**
     * 连通分量  孤岛的数量
     */
    private int count;

    /**
     *
     */
    private int[] parent;

    /**
     * 记录树的重量
     */
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }


    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;

    }


    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }


}
