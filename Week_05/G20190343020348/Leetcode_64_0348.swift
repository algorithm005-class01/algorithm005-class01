

class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        let row = grid.count
        if(row <= 0){
            return 0
        }
        let col = grid[0].count
    
        var dp:[[Int]] = grid
        

        // dp 方程 dp[i][j] = min(dp[i - 1][j],dp[i][j - 1]) + dp[i][j]
        for i in 0 ..< row {
            for j in 0 ..< col{
                if(i == 0){
                    if(j != 0){
                        dp[i][j] = dp[i][j] + dp[i][j-1]
                    }
                }else{
                    
                    if(j == 0){
                        dp[i][j] = dp[i][j] + dp[i - 1][j]
                    }else{
                        dp[i][j] = min(dp[i - 1][j],dp[i][j - 1]) + dp[i][j]
                    }
                    
                }
            }
        }
        
        
        return dp[row - 1][col - 1]
 
    }
}
