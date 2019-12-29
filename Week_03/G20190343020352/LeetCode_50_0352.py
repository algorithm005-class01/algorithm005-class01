class Solution(object):

    def myPow(self, x: float, n: int) -> float:
        result = x
        if x == 0:
            return 0
        if n == 0:
            return 1
        if n > 0:
            for i in range(0, n - 1):
                result = result * x
            return result
        else:
            for i in range(0, n):
                result = result * x
            return 1 / result

    def myPow2(self, x: float, n: int) -> float:
        N = n
        if n < 0:
            x = 1 / x
            N = -n
        return self.fastpow(x, N)

    def fastpow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        half = self.fastpow(x, int(n / 2))
        if n % 2 == 0:
            return half * half
        else:
            return half * half * x

if __name__ == '__main__':
    solution = Solution()
    print(solution.myPow2(2, 10))