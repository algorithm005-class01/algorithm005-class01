#解法1：递归，折半求幂，分正负和奇偶 对结果处理，但是zerodivisionError 没有加上去
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        
        if n < 0:
            n = -n                        #负数转正
            return 1/self.help(x,n)     #返回倒数
        return self.help(x,n)
        
    def help(self,x,n):
        if n == 0:          #递归终止条件
            return 1
        if n % 2 == 0:                          #奇偶处理
            return self.help(x * x,n//2)       #处理当前层，顺便进入下一层
        return self.help(x * x,(n-1)//2) * x

#解法2，对解法1简化，核心思想没变
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1

        if n < 0:
            x = 1/x
            n = -n 
        if n % 2 == 1:
            return x * self.myPow(x*x,(n-1)//2)
        return self.myPow(x*x,n//2)

