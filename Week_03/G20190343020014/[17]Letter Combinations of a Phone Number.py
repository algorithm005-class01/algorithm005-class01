# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
#
# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
#
# 
#
# 示例: 
#
# 输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
# 
#
# 说明: 
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
# Related Topics 字符串 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
pair = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}


class Solution(object):
    def letterCombinations(self, digits):
        """
        使用递归
        """

        def _search(s, i):
            if len(s) == len(digits):
                res.append(s)
                return
            for l in pair.get(digits[i]):
                _search(s + l, i + 1)

        res = []
        _search('', 0)
        return res


class Solution1(object):
    def letterCombinations(self, digits):
        """
        使用回溯模板解决
        """

        def backtracking(path, choice):
            # 满足条件-添加结果
            if len(path) == len(digits) or len(choice) == 0:
                res.append(''.join(path))
                return

            for l in pair.get(choice[0]):
                # 做选择
                path.append(l)
                # 进入下一层决策树
                backtracking(path, choice[1:])
                # 撤销选择
                path.pop()

        res = []
        if not digits: return res
        backtracking([], digits)
        return res


# leetcode submit region end(Prohibit modification and deletion)
r = Solution().letterCombinations('234')
r1 = Solution1().letterCombinations('234')
assert r == r1
print(r)
print(r1)
