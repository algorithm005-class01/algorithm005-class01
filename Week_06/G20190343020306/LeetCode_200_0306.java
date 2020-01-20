class Solution {
    int[] dx = new int[] {0, -1, 0, 1};
    int[] dy = new int[] {-1, 0, 1, 0};

    public int numIslands(char[][] grid) {
        //初始化并查集, 并查集的size为grid中为'1'的格子数
        //但是这里要建立一个机制, 用于将grid坐标转为parent数组下标, 坐标的唯一化引入一个HashMap来存一下
        //grid坐标是二维的, 映射到一维的数字, i * col_num + j
        //遇到1的格子顺序排, 并存入到HashMap中
        int numOfOnes = 0;
        HashMap<Integer, Integer> cordIndexMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int oneDimCord = i * grid[0].length + j;
                    cordIndexMap.put(oneDimCord, numOfOnes);
                    numOfOnes++;
                }
            }
        }
        Union union = new Union(cordIndexMap.size());

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    //与四联通方向任何一个'1'合并
                    boolean isJoint = false;
                    int jointx = i, jointy = j;
                    for (int x = 0, y = 0; x < dx.length && y < dx.length; x++, y++) {
                        jointx = i + dx[x];
                        jointy = j + dy[y];
                        if (jointx >= 0 && jointy >= 0 && jointx < grid.length && jointy < grid[0].length &&
                                grid[i + dx[x]][j + dy[y]] == '1') {
                            union.union(cordIndexMap.get(i * grid[0].length + j), cordIndexMap.get(jointx * grid[0].length + jointy));
                        }
                    }
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