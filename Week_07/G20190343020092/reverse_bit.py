class Solution:
    def reverseBits(self, n: int) -> int:
        #解法一，用内置函数偷懒，注意1.要去除'0b'；2.要填充到32位
        #return int(bin(n)[2:].zfill(32)[::-1],2)
        #解法二. n右移一位取值给左移一位后的res，之后转二进制
        res = 0
        count = 32        
        while count:
            res <<= 1
            res += n&1
            n >>= 1
            count -= 1
            
        return int(bin(res), 2)
