class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        sc = sorted(coins)
        c = len(sc)
        n = 0
        q = []
        while c >= 0: 
            left = amount - sc[c-1]
            if left == 0:
                return len(q)
            if left >=0:
                q.append(sc[c-1])