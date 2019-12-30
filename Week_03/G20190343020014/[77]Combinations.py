#给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
#
# 示例: 
#
# 输入: n = 4, k = 2
#输出:
#[
#  [2,4],
#  [3,4],
#  [2,3],
#  [1,2],
#  [1,3],
#  [1,4],
#] 
# Related Topics 回溯算法



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """

        def backtracking(path, start):
            print(path, start, list(range(start, n + 1)))
            if len(path) == k:
                rs.append(path[:])
                return
                # rs.append(path)
            x = n - (k - len(path)) + 2
            # x = n + 1
            for i in range(start, x):
                path.append(i)
                backtracking(path, i + 1)
                path.pop()

        rs = []
        backtracking([], 1)
        return rs

#leetcode submit region end(Prohibit modification and deletion)
r = Solution().combine(5, 3)
print(r)