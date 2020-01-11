#实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
#
# 示例 1: 
#
# 输入: 2.00000, 10
#输出: 1024.00000
# 
#
# 示例 2: 
#
# 输入: 2.10000, 3
#输出: 9.26100
# 
#
# 示例 3: 
#
# 输入: 2.00000, -2
#输出: 0.25000
#解释: 2-2 = 1/22 = 1/4 = 0.25 
#
# 说明: 
#
# 
# -100.0 < x < 100.0 
# n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
# 
# Related Topics 数学 二分查找



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def myPow1(self, x, n):
        """
        log(n) --> 二分查找时间复杂度
        :type x: float
        :type n: int
        :rtype: float
        """
        # x^-n = 1/x^n = (1/x)^n
        if n < 0:
            return self._recursion(1/x, -n)
        return self._recursion(x, n)

    def _recursion(self, x, n):
        # 终止条件
        if n == 0:
            return 1.0
        # 子问题- drill down
        half = self.myPow(x, n // 2)

        # current state,
        return half * half if n % 2 == 0 else half * half * x

    def myPow(self, x, n):
        if n < 0:
            x = 1/x
            n = abs(n)

        ans = 1
        current_product = x
        i = n
        while i:
            if i % 2 == 1:
                ans = ans * current_product
            current_product *= current_product
            i = i//2
        return ans


#leetcode submit region end(Prohibit modification and deletion)

rs = Solution().myPow(-2.1, 3)
print(rs)
