typedef struct {
    int data;
    int father;
    int rank;
} UFSTree;
void MAKE_SET(UFSTree* t, int n, char** grid, int gridSize, int* gridColSize) {
    int i, j, k;
    for (i = 0; i < gridSize; i++) {
        for (j = 0; j < (*gridColSize); j++) {
            k = i * (*gridColSize) + j;
            if (grid[i][j] == '1') {
                t[k].data = k;
                t[k].father = k;
                t[k].rank = 0;
            } else
                t[k].father = -1;
        }
    }
}
int FIND_SET(UFSTree* t, int x) {
    while (t[x].father != x) {
        x = t[x].father;
    }
    return x;
}
void UNION(UFSTree* t, int x, int y, int* count) {
    x = FIND_SET(t, x);
    y = FIND_SET(t, y);
    if (x >= 0 && y >= 0 && x != y) {
        if (t[x].rank < t[y].rank) {
            t[x].father = y;
        } else {
            t[y].father = x;
            if (t[x].rank == t[y].rank)
                t[x].rank++;
        }
        (*count)--;
    }
}
int numIslands(char** grid, int gridSize, int* gridColSize) {
    if(gridSize == 0)
        return 0;
    int i, j, k1, k2, n = gridSize * (*gridColSize), count = n;
    UFSTree* t = (UFSTree*)malloc(sizeof(UFSTree) * n);
    MAKE_SET(t, n, grid, gridSize, gridColSize);
    for (i = 0; i < gridSize; i++) {
        for (j = 0; j < *gridColSize; j++) {
            if (grid[i][j] == '1') {
                k1 = i * (*gridColSize) + j;
                if (i + 1 < gridSize && grid[i + 1][j] == '1') {
                    k2 = k1 + (*gridColSize);
                    UNION(t, k1, k2, &count);
                    //count是否自减，必须通过UNION函数才能确定，因为有可能k1和k2是同一个树根
                }
                if (j + 1 < *gridColSize && grid[i][j + 1] == '1') {
                    k2 = k1 + 1;
                    UNION(t, k1, k2, &count);
                }
            } else
                count--;
        }
    }
    free(t);
    return count;
}
