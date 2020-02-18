//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // 状态定义：用一维数组记录每一行当前列的通行方案
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];

        // 初始格子默认通行路径为 1
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                // 如果当前格子为障碍物，则通行方案为 0
                if (row[j] == 1) {
                    dp[j] = 0;
                }

                // 每行第一列，如果上一行可通过，则仍然是 1；如果上一行不能通过，则与上一行相同
                // 之后的每一列，都是左侧格子（dp[j - 1]）和上侧格子（实际上就是 dp[j]）之和
                else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[width - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
