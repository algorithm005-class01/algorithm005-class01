class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        # sort O(nlogn)
        # if len(s) != len(t):
        #     return False
        # if sorted(s) != sorted(t):
        #     return False
        # return True

        # map O(n)
        if len(s) != len(t):
            return False
        d = {}
        for i in s:
            d[i] = d.get(i, 0) + 1
        for i in t:
            d[i] = d.get(i, 0) - 1
            if d.get(i) < 0:
                return False
        return True


if __name__ == "__main__":
    solu = Solution()
    print(solu.isAnagram('anagram', 'nagaram'))
