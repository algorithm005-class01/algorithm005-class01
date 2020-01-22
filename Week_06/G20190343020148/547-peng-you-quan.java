
public class Solution {

    public void dfs(int[][] N, int[] visited, int i) {
        for (int j = 0; j < N.length; j++) {
            if (N[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(N, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
