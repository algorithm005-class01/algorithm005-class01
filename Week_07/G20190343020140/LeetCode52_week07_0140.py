#解法1：
class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 1:
            return []
        self.count = 0
        self.dfs(n,0,0,0,0)
        return self.count

    def dfs(self,n,row,cols,pie,na):
        if row >= n:
            self.count += 1
            return 

        bits = (~(cols | pie | na)) & (( 1 << n) -1) # 得到所有的空位，1代表有空位，0 代表没有空位

        while bits:
            p = bits & (-bits) # 取到最低位的1 
            bits = bits & (bits - 1) #保留最近的1，就是空位
            self.dfs(n,row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
            # cols,pie,na 的值并不发生改变
