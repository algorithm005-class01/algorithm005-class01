from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        if n <= 0:
            return []
        self._generate(n, result, 0, 0, "")
        return result

    def _generate(self, n: int, result: [], left: int, right: int, currentStr: str):
        if len(currentStr) == 2 * n:
            result.append(currentStr)
            return

        if left < n:
            self._generate(n, result, left + 1, right, currentStr + "(")
        if right < left:
            self._generate(n, result, left, right + 1, currentStr + ")")

if __name__ == '__main__':
    solution = Solution()
    print(solution.generateParenthesis(3))
