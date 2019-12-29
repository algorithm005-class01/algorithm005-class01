# 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
#
# 
# 每次转换只能改变一个字母。 
# 转换过程中的中间单词必须是字典中的单词。 
# 
#
# 说明: 
#
# 
# 如果不存在这样的转换序列，返回 0。 
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
# 输出: 5
#
# 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
#     返回它的长度 5。
# 
#
# 示例 2: 
#
# 输入:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
#
# 输出: 0
#
# 解释: endWord "cog" 不在字典中，所以无法进行转换。
# Related Topics 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict


class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        q, visited, word_dict = [(beginWord, 1)], [beginWord], self.get_word_dict(wordList)
        while q:
            current, level = q.pop(0)
            status = self.get_word_keys(current)
            for s in status:
                pairs = word_dict.get(s, [])
                for w in pairs:
                    if w == endWord:
                        print(level + 1)
                        return level + 1
                    if w not in visited:
                        visited.append(w)
                        q.append((w, level + 1))
                word_dict[s] = []
        return 0

    def get_word_dict(self, word_list):
        word = defaultdict(list)
        for w in word_list:
            for i in range(len(w)):
                key = w[:i] + '*' + w[i + 1:]
                word[key].append(w)
        return word

    def get_word_keys(self, word):
        return [word[:i] + '*' + word[i + 1:] for i in range(len(word))]


# leetcode submit region end(Prohibit modification and deletion)

x = Solution().ladderLength('hit', 'cog', ["hot", "dot", "dog", "lot", "log", "cog"])
y = Solution().ladderLength('hit', 'cog', ["hot", "dot", "dog", "lot", "log"])
z = Solution().ladderLength('hit', 'lot', ["hot", "dot", "dog", "lot", "log"])
y = Solution().ladderLength('lost', 'miss', ["most", "mist", "miss", "lost", "fist", "fish"])
