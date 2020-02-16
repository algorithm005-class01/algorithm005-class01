# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/counting-bits/"""
from typing import List

class Solution:
    def countBits(self, num: int) -> List[int]:
        res = [0]
        for i in range(1, num + 1):
            if i%2 == 0:
                # i 为偶数， 二进制中1的个数为其1/2数二进制中的1个数
                # 位运算<<，表示将当前数乘以2，即在二进制的最右侧加个0
                res.append(res[i//2])
            else:
                # i 为奇数，二进制中1的个数为前一个偶数中的1个数加1
                res.append(res[i-1] + 1)
        return res