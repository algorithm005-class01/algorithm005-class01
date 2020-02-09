# 191. Number of 1 Bits

# Write a function that takes an unsigned integer and 
# return the number of '1' bits it has (also known as the Hamming weight).

# Example 1:

# Input: 00000000000000000000000000001011
# Output: 3
# Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

class Solution:
    def hammingWeight(self, n: int) -> int:

        # 1. for loop: 0 ----> 32
        # 2. %2, /2
        # 3. &1, x = x >> 1 (32)
        # 3. while x > 0 { count++; x = x & (x - 1); }

        sum = 0
        while n != 0:
            sum += 1
            n = n & (n - 1)
        return sum