"""127. 单词接龙

给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
"""


from collections import defaultdict


class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0

        wordict = set(wordList)
        word_len = len(beginWord)
        level = 0
        forwards = {beginWord}
        backwords = {endWord}
        wordict.remove(endWord)

        # 构建邻接表
        adj = defaultdict(list)
        for word in wordList:
            for i in range(word_len):
                adj[word[:i] + '*' + word[i + 1:]].append(word)

        while forwards and backwords:
            level += 1

            # 总是遍历小的set
            if len(forwards) > len(backwords):
                forwards, backwords = backwords, forwards

            new_set = set()
            for word in forwards:
                for i in range(word_len):
                    new_words = [w for w in adj[word[:i] + '*' + word[i + 1:]]]
                    for new_word in new_words:
                        if new_word in backwords:
                            return level + 1
                        if new_word in wordict:
                            wordict.remove(new_word)
                            new_set.add(new_word)
                        else:
                            continue
            forwards = new_set
        return 0
