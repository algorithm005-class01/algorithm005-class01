from typing import List


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0] or not words:
            return []

        result = set()

        # init Trie
        root, end = {}, "#"
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, {})
            node[end] = True
        
        # DFS
        def DFS(i, j, curWord, curDict, visited):
            curWord += board[i][j]
            curDict = curDict[board[i][j]]
            if end in curDict:
                result.add(curWord)
            for di, dj in ([-1, 0], [1, 0], [0, -1], [0, 1]):
                _i, _j = i + di, j + dj
                if -1 < _i < m and -1 < _j < n and board[_i][_j] in curDict and (_i, _j) not in visited:
                    DFS(_i, _j, curWord, curDict, visited | {(_i, _j)})


        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in root:
                    DFS(i, j, '', root, {(i, j)})
        return list(result)


if __name__ == "__main__":
    board = [["b","a","a","b","a","b"],["a","b","a","a","a","a"],["a","b","a","a","a","b"],["a","b","a","b","b","a"],["a","a","b","b","a","b"],["a","a","b","b","b","a"],["a","a","b","a","a","b"]]
    words = ["bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"]
    solution = Solution()
    print(solution.findWords(board, words))