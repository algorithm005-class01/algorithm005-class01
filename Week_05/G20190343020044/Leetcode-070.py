class Solution:
    def climbStairs(self, n: int) -> int:
        fib = [1,1,2,3] #initial list
        if n < 4:
            return fib[n]
        for i in range(4, n+1):
            fib.append(fib[i-1]+fib[i-2])
        return fib[-1]