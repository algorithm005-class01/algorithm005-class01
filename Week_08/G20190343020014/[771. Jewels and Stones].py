class Solution:
    def numJewelsInStones1(self, J: str, S: str) -> int:
        count = 0
        for i in S:
            if i in J:
                count += 1
        return count

    def numJewelsInStones(self, J: str, S: str) -> int:
        M_MAP = {}
        for j in J:
            M_MAP[j] = 1

        count = 0
        for i in S:
            if i in J_MAP.keys():
                count += 1
        return count
