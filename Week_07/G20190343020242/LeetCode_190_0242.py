#
# @lc app=leetcode.cn id=190 lang=python3
#
# [190] 颠倒二进制位
#
# https://leetcode-cn.com/problems/reverse-bits/description/
#
# algorithms
# Easy (51.74%)
# Likes:    118
# Dislikes: 0
# Total Accepted:    27.9K
# Total Submissions: 52.2K
# Testcase Example:  '00000010100101000001111010011100'
#
# 颠倒给定的 32 位无符号整数的二进制位。
#
#
#
# 示例 1：
#
# 输入: 00000010100101000001111010011100
# 输出: 00111001011110000010100101000000
# 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
# ⁠     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
#
# 示例 2：
#
# 输入：11111111111111111111111111111101
# 输出：10111111111111111111111111111111
# 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
# 因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
#
#
#
# 提示：
#
#
# 请注意，在某些语言（如
# Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
# 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数
# -1073741825。
#
#
#
#
# 进阶:
# 如果多次调用这个函数，你将如何优化你的算法？
#
#


# @lc code=start
class Solution:

    def reverseBits_1(self, n: int) -> int:
        res = 0
        count = 32
        while count:
            res = res << 1
            res += n & 1
            n = n >> 1
            count -= 1
        return res

    def reverseBits(self, n: int) -> int:
        # 检查 n 的第 i 位是否位 1，是，将 31-i 位设为 1
        ans, mask = 0, 1
        for i in range(32):
            if n & mask:
                ans = ans | 1 << (31 - i)
            mask = mask << 1
        return ans

    def reverseBits2(self, n):
        res = 0
        while n > 0:
            last_one_index = int(n & (-n)).bit_length() - 1     # 最后一个 1 的索引
            res = res | (1 << (31 - last_one_index))     # 将第 31-i 索引处置为 1
            n = n & (n - 1)
        return res


# @lc code=end
