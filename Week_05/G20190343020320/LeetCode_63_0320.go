package g20190343020320

// 63.不同路径2
// https://leetcode-cn.com/problems/unique-paths-ii/

func UniquePathsWithObstacles(obstacleGrid [][]int) int {
	ol := len(obstacleGrid) - 1

	if obstacleGrid[ol][len(obstacleGrid[ol])-1] == 1 {
		return 0
	}

	obstacleGrid[ol][len(obstacleGrid[ol])-1] = 1
	for i := ol; i >= 0; i-- {
		il := len(obstacleGrid[i]) - 1
		for j := il; j >= 0; j-- {
			if obstacleGrid[i][j] == 1 {
				if i != ol || j != il {
					obstacleGrid[i][j] = 0
				}
			} else if i == ol {
				obstacleGrid[i][j] = obstacleGrid[i][j+1]
			} else if j == il {
				obstacleGrid[i][j] = obstacleGrid[i+1][j]
			} else {
				obstacleGrid[i][j] = obstacleGrid[i+1][j] + obstacleGrid[i][j+1]
			}
		}
	}
	return obstacleGrid[0][0]
}
