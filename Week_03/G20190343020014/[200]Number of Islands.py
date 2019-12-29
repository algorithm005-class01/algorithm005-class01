# 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
#
# 示例 1: 
#
# 输入:
# 11110
# 11010
# 11000
# 00000
#
# 输出: 1
# 
#
# 示例 2: 
#
# 输入:
# 11000
# 11000
# 00100
# 00011
#
# 输出: 3
# 
# Related Topics 深度优先搜索 广度优先搜索 并查集


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def numIslands0(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid: return 0

        def dfs(row, col):
            # 终止条件
            if row < 0 or col < 0 or row >= nr or col >= nc or grid[row][col] == '0':
                return

            # 处理当前层-染色
            grid[row][col] = '0'

            # 去下一层
            dfs(row - 1, col)  # 向上
            dfs(row + 1, col)  # 向下
            dfs(row, col - 1)  # 左
            dfs(row, col + 1)  # 右

        nr, nc, count = len(grid), len(grid[0]), 0
        for r in range(nr):
            for c in range(nc):
                if grid[r][c] == '1':
                    count += 1
                    dfs(r, c)

        return count

    # 使用广度优先搜索
    def numIslands(self, grid):
        if not grid: return 0
        nr, nc, count = len(grid), len(grid[0]), 0

        for r in range(nr):
            for c in range(nc):
                if grid[r][c] == '0':
                    continue
                count += 1
                grid[r][c] = '0'

                q = [(r, c)]
                while q:
                    row, col = q.pop(0)
                    if row - 1 >= 0 and grid[row - 1][col] == '1':
                        q.append((row - 1, col))
                        grid[row - 1][col] = '0'

                    if row + 1 < nr and grid[row + 1][col] == '1':
                        q.append((row + 1, col))
                        grid[row + 1][col] = '0'

                    if col - 1 >= 0 and grid[row][col - 1] == '1':
                        q.append((row, col - 1))
                        grid[row][col - 1] = '0'

                    if col + 1 < nc and grid[row][col + 1] == '1':
                        q.append((row, col + 1))
                        grid[row][col + 1] = '0'
        return count

    def numIslands(self, grid):
        """并查集解决"""
        pass


# leetcode submit region end(Prohibit modification and deletion)

test_case1 = [
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"]]

print(Solution().numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]))
