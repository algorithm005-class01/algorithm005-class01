class Solution:
    def plusOne(self, digits: list) -> list:
        if digits is None:
            return None
        i = len(digits) - 1
        while i >= 0:
            digits[i] = digits[i] + 1
            digits[i] = digits[i] % 10
            if digits[i] > 0:
                return digits
            i = i - 1
        result = [1]
        for j in range(len(digits)):
            result.append(digits[j])
        return result