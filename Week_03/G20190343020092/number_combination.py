class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        #维护一个字典保存每个数字对应的字母
        myMap = {
                '2': ['a', 'b', 'c'],
                '3': ['d', 'e', 'f'],
                '4': ['g', 'h', 'i'],
                '5': ['j', 'k', 'l'],
                '6': ['m', 'n', 'o'],
                '7': ['p', 'q', 'r', 's'],
                '8': ['t', 'u', 'v'],
                '9': ['w', 'x', 'y', 'z']
        }
        result = []
        #回溯法，遍历所有可能的情况
        def backtrack(tmp_result, myDigits):
            #递归终止条件为：读取了传入的所有数字
            if len(myDigits) == 0:
                result.append(tmp_result)
                return
            curDigit = myDigits[0]
            #在字典中找到当前数字对应的所有字母，并添加到结果数组中
            for letter in myMap[curDigit]:
                backtrack(tmp_result + letter, myDigits[1:])
        if len(digits) == 0:
            return []
        backtrack("", digits)
        return result
