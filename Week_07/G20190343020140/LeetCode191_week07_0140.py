#解法1：
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        return bin(n).count('1')

#解法2：
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        n = bin(n)
        count = 0
        for c in n:
            if c == '1':
                count += 1 
        return count

#解法3：
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            res = n % 2
            if res == 1:
                count += 1
            n //= 2
        return count

#解法4：
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            count += n & 1
            n >>= 1
        return count

#解法5：
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            count += 1
            n = n & (n - 1)
        
        return count

            
