#!/user/bin/python
#-*- coding:utf-8 -*-


class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0
        for _ in range(32):
            ans = (ans << 1) + (n & 1)
            n = n >> 1
        return ans

    def reverseBits_v1(self, n: int) -> int:
        oribin = format(n,'032b')
        reverse_bin = oribin[::-1]
        return(int(reverse_bin, 2))



import unittest
class SolutionTest(unittest.TestCase):
    def testSolution(self):
        solution = Solution()
        self.assertTrue(solution.reverseBits(0b00000010100101000001111010011100) == 0b00111001011110000010100101000000)
        self.assertTrue(solution.reverseBits(0b11111111111111111111111111111101) == 0b10111111111111111111111111111111)

if __name__ == "__main__" : unittest.main()