class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 1 });
        grid[0][0] = 2;
        int[][] dirs = { { 1, 0 }, { 1, -1 }, { 1, 1 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { -1, -1 } };
        int N = grid.length;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N * N - 1)
                return cur[1];
            for (int i = 0; i < 8; i++) {
                int nx = cur[0] / N + dirs[i][0], ny = cur[0] % N + dirs[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] != 0)
                    continue;
                q.offer(new int[] { nx * N + ny, cur[1] + 1 });
                grid[nx][ny] = 2;
            }
        }
        return -1;
    }
}