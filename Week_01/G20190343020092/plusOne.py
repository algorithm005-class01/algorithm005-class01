class Solution:
#分为两种情况
# 1.不等于9的元素，加一即可
# 2.等于9的情况，置0 且需要考虑新增以为，例如 99（两位数） + 1 =100（三位数）
    def plusOne(self, digits: List[int]) -> List[int]:
        if digits[0] == 0:
            return [1]
        for i in range(len(digits)-1, -1, -1):
            if digits[i] == 9 and i == 0:
                digits[i] = 0
                digits.insert(0,1)
                continue
            elif digits[i] == 9:
                digits[i] = 0
                continue
            else:
                digits[i] += 1
                break
        return digits
