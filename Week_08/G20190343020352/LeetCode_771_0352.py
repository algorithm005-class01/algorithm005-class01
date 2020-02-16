class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        Jset = set(J)
        return sum(s in Jset for s in S)