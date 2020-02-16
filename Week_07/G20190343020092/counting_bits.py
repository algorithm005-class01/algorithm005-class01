class Solution:
    def countBits(self, num: int) -> List[int]:
        result = [None] * (num + 1)
        result[0] = 0
        if num < 0:
            return []
        for i in range(1, num+1):
            #奇数
            if i & 1 == 1:
                result[i] = result[i-1] + 1
            else:
                result[i] = result[i//2]
        return result
