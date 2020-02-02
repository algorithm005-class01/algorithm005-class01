#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start

# from collections import defaultdict
# class Solution:
#     # 超时，效率不行, 想将访问过的dict清空有bug……
#     def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
#         if not beginWord or not endWord: return 0
#         if endWord not in wordList or not wordList: return 0

#         wordList = set(wordList)
#         l = len(beginWord)
#         all_possible_dict = defaultdict(list)
#         for word in wordList:
#             for i in range(l):
#                 all_possible_dict[word[:i] + '*' + word[i + 1:]].append(word)
        
#         def helper(word, length, _wordList):
#             if word == endWord: 
#                 lengths.append(length) 
#                 return
#             if not _wordList: return
            
#             for i in range(l):
#                 curr_word_type = word[:i] + '*' + word[i + 1:]

#                 for new_word in all_possible_dict[curr_word_type]:
#                     if new_word in _wordList:
#                         _wordList.remove(new_word)
#                         helper(new_word, length + 1, _wordList)
#                         _wordList.add(new_word)
#         lengths = []
#         helper(beginWord, 1, wordList)
#         if not lengths: return 0
#         else: return min(lengths)


import string
class Solution:
    # 双向bfs
    def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
        if endWord not in wordList or not wordList: return 0

        wordList = set(wordList)
        wordlen = len(beginWord)
        beginSet = {beginWord}
        endSet = {endWord}
        dist = 1
        # visited = set()
        while beginSet:
            dist += 1
            next_set = set()
            for word in beginSet:
                for i in range(wordlen):
                    for c in string.ascii_lowercase:
                        new = word[:i] + c + word[i+1:]
                        if new in endSet:
                            return dist
                        if new in wordList:
                            next_set.add(new)
                            wordList.remove(new)
                        # if new not in visited and new in wordList:
                        #     next_set.add(new)
                        #     visited.add(new)
            # 找到新的合法的beginSet
            beginSet = next_set
            # 找较小的set进行处理
            if len(beginSet) > len(endSet):
                beginSet, endSet = endSet, beginSet
        return 0

# @lc code=end

if __name__ == "__main__":
    start = "qa"
    end =   "sq"
    bank =  ["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
    res = Solution().ladderLength(start, end, bank)
    print(res)