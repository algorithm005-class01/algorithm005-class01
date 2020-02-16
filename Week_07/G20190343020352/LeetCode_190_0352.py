class Solution:
    def reverseBits(self, n: int) -> int:
        temp, MASK = 0, 1
        for i in range(32):
            if n & MASK:
                temp |= 1 << (31 - i)
            MASK <<= 1
        return temp