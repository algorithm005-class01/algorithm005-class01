from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not beginWord or not endWord or not wordList or endWord not in wordList:
            return 0
        begin = {beginWord}
        end = {endWord}
        wordList = set(wordList)
        count = 1
        chars = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
        
        while begin:
            count += 1
            temp = set()
            for word in begin:
                for i in range(len(word)):
                    for char in chars:
                        if char != word[i]:
                            curWord = word[:i] + char + word[i+1:]
                            if curWord in end:
                                return count
                            if curWord in wordList:
                                temp.add(curWord)
                                wordList.remove(curWord)
            begin = temp
            if len(begin) > len(end):
                begin, end = end, begin
        
        return 0