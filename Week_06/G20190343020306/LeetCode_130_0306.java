class Solution {
    int[] dx = new int[] {-1, 0};
    int[] dy = new int[] {0, -1};

    public void solve(char[][] board) {

        int Ocount = 0;
        Map<Integer, Integer> oneDimCordIndexMap = new HashMap<>();
        //找到board中O的区域, 加入并查集
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    oneDimCordIndexMap.put(i * board[0].length + j, Ocount);
                    Ocount++;
                }
            }
        }
        Union union = new Union(Ocount);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    for (int x = 0, y = 0; x < dx.length && y < dy.length; x++, y++) {
                        int jointx = i + dx[x];
                        int jointy = j + dy[y];
                        if (jointx >= 0 && jointy >= 0 && jointx < board.length && jointy < board[0].length
                                && board[jointx][jointy] == 'O') {
                            union.union(
                                    oneDimCordIndexMap.get(i * board[0].length + j),
                                    oneDimCordIndexMap.get(jointx * board[0].length + jointy)
                            );
                        }
                    }
                }

            }
        }

        //找到并查集的count以及代表元素, 根据代表元素再拉出一个HashMap
        HashMap<Integer, List<Integer>> OSets = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: oneDimCordIndexMap.entrySet()) {
            int rootP = union.find(entry.getValue());
            if (!OSets.containsKey(rootP)) {
                OSets.put(rootP, new ArrayList<>());
            }
            OSets.get(rootP).add(entry.getKey()); //将坐标加进去
        }

        //如果并查集里面的元素都不在边界上, 那么将元素填充为X
        for (Map.Entry<Integer, List<Integer>> entry: OSets.entrySet()) {
            boolean noCorner = true;
            for (int cord: entry.getValue()) {
                //行使用cord / col_num求出, 列使用cord % col_num求出
                int row = cord / board[0].length;
                int col = cord % board[0].length;
                if (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1) {
                    noCorner = false;
                    break;
                }
            }
            if (noCorner) {
                for (int cord: entry.getValue()) {
                    //行使用cord / col_num求出, 列使用cord % col_num求出
                    int row = cord / board[0].length;
                    int col = cord % board[0].length;
                    board[row][col] = 'X';
                }
            }
        }
    }
}

class Union {
    private int count;
    private int[] parent;

    public int[] getParent() {
        return parent;
    }

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