"""
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
"""


class Solution(object):
    def my_pow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        时间复杂度 O(logN) 空间复杂度 O(logN)

        快速幂算法
        """
        if n == 0:
            return 1
        if n == 1:
            return x
        if n == -1:
            return 1 / x
        half = self.my_pow(x, n / 2)
        rest = self.my_pow(x, n % 2)
        return half * half * rest
