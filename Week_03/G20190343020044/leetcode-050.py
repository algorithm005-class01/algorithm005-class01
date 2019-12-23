class Solution
    def myPow(self, x float, n int) - float
        if n == 0
            return 1
        if n = 0
            return 1self.myPow(x,-n)
        if n%2 == 0
            sqrt = self.myPow(x,n2)
            return sqrt  sqrt
        else
            sqrt = self.myPow(x,(n-1)2)
            return sqrt  sqrt  x