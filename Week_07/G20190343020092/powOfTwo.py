class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n and (n & (n-1)==0)
