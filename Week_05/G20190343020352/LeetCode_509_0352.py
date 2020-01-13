class Solution(object):

    def fib(self, n: int) -> int:
        memo = [0] * (n + 1)
        return self.fibonacci(n, memo)

    def fibonacci(self, n: int, memo: [int]) -> int:
        if n <= 1:
            return n
        if memo[n] == 0:
            memo[n] = self.fibonacci(n - 1, memo) + self.fibonacci(n - 2, memo)
        return memo[n]


if __name__ == '__main__':
    solution = Solution()
    n = 3
    print(solution.fib(4))
