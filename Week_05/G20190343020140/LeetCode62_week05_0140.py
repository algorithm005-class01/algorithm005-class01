#解法1：DP 二维数组，自顶向上
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        table = [[1]* n] + [[1]+[0]*(n-1) for _ in range(m-1)]
        for i in range(1,m):
            for j in range(1,n):
                    table[i][j] = table[i-1][j] + table[i][j-1]
        return table[m-1][n-1]

#解法2：优化DP,用两个一维数组，自顶向上
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        pre =[1] * n
        cur = [1] * n
        for i in range(1,m):
            for j in range(1,n):
                cur[j] = pre[j] +cur[j-1]
            pre = cur[:]
        return pre[-1]

#解法3，优化解法2，用一个数组，自顶向上
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        cur = [1] * n
        for i in range(1,m):
           for j in range(1,n):
               cur[j] += cur[j-1]
        return cur[-1]

#解法4，数学法，排列组合
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        return int(math.factorial(m+n-2)/(math.factorial(m-1)*math.factorial(n-1)))
