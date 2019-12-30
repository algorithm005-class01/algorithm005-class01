from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if str is None or len(digits) == 0:
            return []
        result = [str]
        hashMap = {}
        hashMap.setdefault('2', 'abc')
        hashMap.setdefault('3', 'def')
        hashMap.setdefault('4', 'ghi')
        hashMap.setdefault('5', 'jkl')
        hashMap.setdefault('6', 'mno')
        hashMap.setdefault('7', 'pqrs')
        hashMap.setdefault('8', 'tuv')
        hashMap.setdefault('9', 'wxyz')
        self.combination('', digits, hashMap, 0, result)
        return result

    def combination(self, string: str, digits: str, hashMap: dict, level: int, result: List[str]):
        if level > len(digits) - 1:
            result.append(string)
            return

        mapvalue = hashMap[digits[level]]
        for i in range(0, len(mapvalue)):
            self.combination(string.__add__(mapvalue[i]), digits, hashMap, level + 1, result)

if __name__ == '__main__':
    solution = Solution()

    print(solution.letterCombinations('234'))
