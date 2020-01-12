# Dynamic Programming

## 小结

看完老师讲解的内容之后，真的大脑一片空白……好难啊……

如果说记得什么，那应该就这 3 点了：

- 子问题
- 状态定义
- DP 方程

下面这两道题是作业里能理解的最简单的两个了……后续还要再多看、多练！

## 64.最小路径和

老师最初例子的简化版，写一下用来巩固记忆。(一开始在边界上想的还是简单了，错误了几次。)

``` Java
public int minPathSum(int[][] grid) {
    // 1. 子问题：当前点到达最后点的最小距离
    // 2. 状态定义：dp[row][col]
    // 3. DP 方程：dp[row][col] = grid[row][col] + min(dp[row - 1][col], dp[row][col - 1])

    int rowLength = grid.length;
    int colLength = grid[0].length;

    int[][] dp = new int[rowLength][colLength];

    for (int r = rowLength - 1; r >= 0; r--) {
        for (int c = colLength - 1; c >= 0; c--) {
            // 最后终结的节点，返回当前值
            if (r == rowLength - 1 && c == colLength - 1) {
                dp[r][c] = grid[r][c];
            }
            // 最下面的一行，只需要累加右边的值
            else if (r == rowLength - 1 && c != colLength - 1) {
                dp[r][c] = grid[r][c] + dp[r][c + 1];
            }
            // 最右边的一列，只需要累加下面的值
            else if (r != rowLength - 1 && c == colLength - 1) {
                dp[r][c] = grid[r][c] + dp[r + 1][c];
            }
            // 如果存在下面、右边节点，当前最小路径 = 当前节点长度 + min(下面节点, 右面节点)
            else {
                dp[r][c] = grid[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
            }
        }
    }
    return dp[0][0];
}
```

## 221. 最大正方形

``` Java
public int maximalSquare(char[][] matrix) {

    int rowLength = matrix.length;
    int colLength = matrix.length > 0 ? matrix[0].length : 0;

    int[][] dp = new int[rowLength + 1][colLength + 1];
    int maxSideLen = 0;

    for (int r = 1; r <= rowLength; r++) {
        for (int c = 1; c <= colLength; c++) {
            // 如果当前位置是岛，查看是否能与之前相邻的位置组成更大的矩形
            if (matrix[r - 1][c - 1] == '1') {
                dp[r][c] = Math.min(Math.min(dp[r][c - 1], dp[r - 1][c]), dp[r - 1][c - 1]) + 1;
                maxSideLen = Math.max(maxSideLen, dp[r][c]);
            }
        }
    }
    return maxSideLen * maxSideLen;
}
```
