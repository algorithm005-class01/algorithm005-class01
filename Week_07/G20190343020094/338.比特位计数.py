#
# @lc app=leetcode.cn id=338 lang=python3
#
# [338] 比特位计数
#

# @lc code=start
class Solution:
    # # 1. 这是我的傻for loop 200ms
    # def countBits(self, num: int) -> List[int]:
    #     res = [0]
    #     count = 1
    #     for i in range(1, num+1):
    #         a = i&(i-1)
    #         while a:
    #             count +=1
    #             a = a & (a-1)
    #         res.append(count)
    #         count = 1
    #     return res
    # # 2. 动态规划 + 最高有效位 88ms
    # def countBits(self, num: int) -> List[int]:
    #     res = [0] * (num + 1)
    #     i = 0
    #     b = 1

    #     while b <= num:
    #         # generate [b,2b) or [b, num) from [0, b)
    #         while i < b and i + b <= num:
    #             res[i+b] = res[i] + 1
    #             i += 1
    #         i = 0
    #         b <<= 1
    #     return res

    # 3. 动态规划 + 最低有效位 108ms
    # 状态转移函数 P(x)=P(x/2)+(x % 2)
    def countBits(self, num: int) -> List[int]:
        res = [0] * (num + 1)
        for i in range(1, num+1):
            # x / 2 is x >> 1 and x % 2 is x & 1
            res[i] = res[i>>1] + (i & 1)
        return res
            
# @lc code=end

