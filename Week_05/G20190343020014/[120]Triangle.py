#给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
#
# 例如，给定三角形：
#
# [
#     [2],
#    [3,4],
#   [6,5,7],
#  [4,1,8,3]
#]
#
#
# 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
#
# 说明：
#
# 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
# Related Topics 数组 动态规划



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def minimumTotal1(self, triangle):
        dp = triangle
        for i in range(len(dp) - 2, -1, -1):
            for j in range(len(dp[i])):
                dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j]
        # for x in dp:
        #     print(x)
        return dp[0][0]

    def minimumTotal2(self, triangle):
        dp = triangle[-1]  # 每次字需要记录上一层的状态即可知道当前层的结果
        # print(dp)
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j]
            print(dp)
        return dp[0]

    def minimumTotal(self, triangle):
        # 自顶向下的写法-每一层计算一次， 最后取最后一层的最小值
        # 初始化一个结果集
        res = [[0 for _ in range(len(row))] for row in triangle]
        res[0][0] = triangle[0][0]  # 第一层的和就是它自己
        for i in range(1, len(triangle)):
            for j in range(len(triangle[i])):
                if j == 0:   # 最左边，只有一个路径
                    res[i][j] = res[i - 1][j] + triangle[i][j]
                if j == len(triangle[i]) - 1:  # 最右边也只有一个路径
                    res[i][j] = res[i - 1][j - 1] + triangle[i][j]
                else:
                    res[i][j] = min(res[i-1][j], res[i-1][j-1]) + triangle[i][j]
        for x in res:
            print(x)
        return min(res[-1])


#leetcode submit region end(Prohibit modification and deletion)
t = [
    [2],
    [3, 4],
    [6, 5, 7],
    [4, 1, 8, 3],
    [4, 111, 8, 3, 8],
]
Solution().minimumTotal(t)
