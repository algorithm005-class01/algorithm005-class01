#解法1：记忆化递归，自顶向下
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return 0
        n = len(triangle)
        m = len(triangle[-1])
        memo = [[0 for _ in range(m)] for _ in range(n)]
        return self.minPath(0,0,triangle,memo)
    
    def minPath(self,row,col,triangle,memo):
        if row + 1 == len(triangle):
            return triangle[row][col]
        if not memo[row][col]:    
            memo[row][col] = triangle[row][col] + min(self.minPath(row+1,col,triangle,memo), self.minPath(row+1,col+1,triangle,memo))
        return memo[row][col]

#解法2：DP 二维数组，自顶向下，原地操作
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return 0
        if len(triangle) <= 1:
            return triangle[0][0]
        row = len(triangle)
        
        for i in range(1,row):
            for j in xrange(len(triangle[i])):
                if j == 0:
                    triangle[i][j] += triangle[i-1][j]
                elif j == len(triangle[i])-1:
                    triangle[i][j] += triangle[i-1][j-1]
                else:
                    triangle[i][j] += min(triangle[i-1][j-1],triangle[i-1][j])
            
           
        return min(triangle[-1])

#解法3：DP 二维数组，自底向上，原地操作
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return 0
        if len(triangle) <= 1:
            return triangle[0][0]
        
        
        for i in range(len(triangle)-2,-1,-1):
            for j in xrange(len(triangle[i])):
                triangle[i][j] += min(triangle[i+1][j],triangle[i+1][j+1])
            
           
        return triangle[0][0]

#解法4：用两个一维数组，自顶向下
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return 0
        if len(triangle) <= 1:
            return triangle[0][0]
        row = len(triangle)
        pre = triangle[0]
        for i in range(1,row):
            
            cur = triangle[i]
        
            cur[0] += pre[0]
            cur[-1] += pre[-1]
            for i, v in enumerate(cur[1:-1]):
                cur[i+1] = min(pre[i],pre[i+1]) + v
            pre = cur
        return min(cur)

#解法5：开辟一个一维数组，自底向上
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return 0
        if len(triangle) <= 1:
            return triangle[0][0]   
        res = triangle[-1]
        for i in range(len(triangle)-2,-1,-1):
            for j in xrange(len(triangle[i])):
                res[j] = min(res[j],res[j+1]) +triangle[i][j]   
           
        return res[0]

#解法6：自底向上，zip 操作，优化代码
def minimumTotal(triangle):
    def combine_rows(lower_row, upper_row):
        from functools import reduce
        return [upper + min(lower_left, lower_right)
                for upper, lower_left, lower_right in
                zip(upper_row, lower_row, lower_row[1:])]
        
    return reduce(combine_rows, triangle[::-1])[0]

#解法7：自底向上，zip 操作，简化解法6代码
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        return reduce(lambda a,b:[f+min(d,e)for f,d,e in zip(b,a,a[1:])],triangle[::-1])[0]
