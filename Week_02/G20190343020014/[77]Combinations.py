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

        def backtrack(first=1, curr=[]):
            # if the combination is done
            if len(curr) == k:
                output.append(curr[:])
            for i in range(first, n + 1):
                # add i into the current combination
                curr.append(i)
                # use next integers to complete the combination
                backtrack(i + 1, curr)
                # backtrack
                curr.pop()

        output = []
        backtrack()
        return output
        
#leetcode submit region end(Prohibit modification and deletion)
