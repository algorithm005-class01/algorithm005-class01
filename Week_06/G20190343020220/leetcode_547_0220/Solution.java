package Week_06.G20190343020220.leetcode_547_0220;

/**
 * @author Darcy
 * @date 2020-01-15 10:20
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count();
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 1}, {0, 0, 1}};
        int circleNum = new Solution().findCircleNum(M);
        System.out.println("circleNum = " + circleNum);
    }
}
