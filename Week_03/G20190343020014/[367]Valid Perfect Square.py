# 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
#
# 说明：不要使用任何内置的库函数，如 sqrt。 
#
# 示例 1： 
#
# 输入：16
# 输出：True
#
# 示例 2： 
#
# 输入：14
# 输出：False
# 
# Related Topics 数学 二分查找


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 2: return True
        left, right = 2, num // 2
        while left <= right:
            # x = (left + right) // 2  可能溢出
            x = left + (right - left) // 2
            print(x)
            sq = x * x
            if sq == num:
                return True
            if sq > num:
                right = x - 1
            else:
                left = x + 1
        return False

# leetcode submit region end(Prohibit modification and deletion)

ps = Solution().isPerfectSquare(100)
print(ps)
