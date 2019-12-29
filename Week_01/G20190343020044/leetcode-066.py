class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if digits == [9]:
            return [1,0]
    
        n = len(digits)
        digits[-1] += 1

        if n == 1:
            return digits
        
        for i in range(n-1):
            if digits[-i-1] == 10:
                digits[-i-1] = 0
                digits[-i-2] += 1
        if digits[0] == 10:
            digits[0] = 1
            digits.append(0)
        
        return digits