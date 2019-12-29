# 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
#
# 
# 每次转换只能改变一个字母。 
# 转换过程中的中间单词必须是字典中的单词。 
# 
#
# 说明: 
#
# 
# 如果不存在这样的转换序列，返回一个空列表。 
# 所有单词具有相同的长度。 
# 所有单词只由小写字母组成。 
# 字典中不存在重复的单词。 
# 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
# 
#
# 示例 1: 
#
# 输入:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
#
# 输出:
# [
#  ["hit","hot","dot","dog","cog"],
#   ["hit","hot","lot","log","cog"]
# ]
# 
#
# 示例 2: 
#
# 输入:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
#
# 输出: []
#
# 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
# Related Topics 广度优先搜索 数组 字符串 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict


class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """

        # 超时了
        if endWord not in wordList:
            return []

        res, visited = [], [beginWord]
        word_dict = self.get_word_dict(wordList)

        def backtrack(path, choice):
            m = len(res[-1]) if res else float('inf')
            if len(path) > m:
                return

            if path[-1] == endWord:
                if not res:
                    res.append(path[:])
                    return
                m = len(res[-1]) if res else float('inf')
                if len(path) == m:
                    res.append(path[:])
                    return

                while res:
                    m = len(res[-1]) if res else float('inf')
                    if len(path) < m:
                        res.pop()
                res.append(path[:])
                return

            # # print(choice)
            for c in choice:
                if c in visited:
                    continue
                if not self.is_next(path[-1], c, word_dict):
                    continue

                # 选择
                path.append(c)
                # 进入下一次层决策
                backtrack(path, [x for x in choice if x != c])
                # 撤销选择
                path.pop()

        backtrack([beginWord], set(wordList))
        return res

    def is_next(self, current, c, word_dict):
        for pt in (current[0] + "*", "*" + current[-1]):
            if c in word_dict.get(pt, []):
                return True
        return False


    def get_word_dict(self, lst):
        wd = defaultdict(list)
        for word in lst:
            wd[word[0] + "*"].append(word)
            wd["*" + word[-1]].append(word)
        return wd

    def findLadders1(self, beginWord, endWord, wordList):
        # bfs
        if endWord not in wordList:
            return []
        q, visited, res, word_dict = [(beginWord, [beginWord])], [beginWord], [], self.get_word_dict(wordList)

        while q:
            current, path = q.pop(0)
            print(current, path)
            if current == endWord:
                res.append(path)
            for pt in (current[0] + "*", "*" + current[-1]):
                for next_word in word_dict.get(pt, []):
                    if next_word not in visited:
                        visited.append(next_word)
                        q.append((next_word, path + [next_word]))
                word_dict[pt] = []
        return res



# leetcode subXmit region end(Prohibit modification and deletion)


# begin, end, word_list = 'hit', 'cog', ["hot", "dot", "dog", "lot", "log", "cog"]
# begin, end, word_list = 'hit', 'cog', ["hot", "dot", "dog", "lot", "log", "cog"]
begin, end, word_list = "qa", "sq", ["si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le",
                                     "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn",
                                     "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc",
                                     "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co",
                                     "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an",
                                     "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io",
                                     "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"]

# begin, end, word_list = 'hit', 'cog', ["hot", "dot", "dog", "lot", "log"]
import time
print(time.clock())
out = Solution().findLadders(begin, end, word_list)
print(time.clock())
print("*" * 50)
for o in out:
    print(o)


# [["qa","ba","be","se","sq"],["qa","ba","bi","si","sq"],["qa","ba","br","sr","sq"],["qa","ca","cm","sm","sq"],["qa","ca","co","so","sq"],["qa","la","ln","sn","sq"],["qa","la","lt","st","sq"],["qa","ma","mb","sb","sq"],["qa","pa","ph","sh","sq"],["qa","ta","tc","sc","sq"],["qa","fa","fe","se","sq"],["qa","ga","ge","se","sq"],["qa","ha","he","se","sq"],["qa","la","le","se","sq"],["qa","ma","me","se","sq"],["qa","na","ne","se","sq"],["qa","ra","re","se","sq"],["qa","ya","ye","se","sq"],["qa","ca","ci","si","sq"],["qa","ha","hi","si","sq"],["qa","la","li","si","sq"],["qa","ma","mi","si","sq"],["qa","na","ni","si","sq"],["qa","pa","pi","si","sq"],["qa","ta","ti","si","sq"],["qa","ca","cr","sr","sq"],["qa","fa","fr","sr","sq"],["qa","la","lr","sr","sq"],["qa","ma","mr","sr","sq"],["qa","fa","fm","sm","sq"],["qa","pa","pm","sm","sq"],["qa","ta","tm","sm","sq"],["qa","ga","go","so","sq"],["qa","ha","ho","so","sq"],["qa","la","lo","so","sq"],["qa","ma","mo","so","sq"],["qa","na","no","so","sq"],...