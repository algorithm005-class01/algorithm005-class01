#解法1 回溯法，mark 数组标记有无访问,最后要把board 状态还原
class Solution(object):
    directions = [(0,1),(0,-1),(1,0),(-1,0)]
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m = len(board)
        n = len(board[0])
        if m == 0:
            return False
        mark = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    mark[i][j] = 1
                    if self.backtrack(i,j,mark,board,word[1:]) == True:
                        return True
                    else:
                        mark[i][j] = 0
        return False

    def backtrack(self,i,j,mark,board,word):
        if len(word) == 0:
            return True
        for direct in self.directions:
            cur_i = i + direct[0]
            cur_j = j + direct[1]
            if cur_i >= 0 and cur_i < len(board) and cur_j >= 0 and cur_j < len(board[0]) and board[cur_i][cur_j] == word[0]:
                if mark[cur_i][cur_j] == 1:
                    continue
                mark[cur_i][cur_j] = 1
                if self.backtrack(cur_i,cur_j,mark,board,word[1:]) == True:
                    return True
                else:
                    mark[cur_i][cur_j] = 0
        return False
                
#解法2 DFS
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not board:
            return False  
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board,i,j,word):
                    return True
        return False

    def dfs(self,board,i,j,word):
        if len(word) == 0:
            return True 
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or word[0] != board[i][j]:
            return False
        temp = board[i][j]
        board[i][j] = '#'
        res = self.dfs(board,i-1,j,word[1:]) or self.dfs(board,i+1,j,word[1:]) or self.dfs(board,i,j-1,word[1:]) or self.dfs(board,i,j+1,word[1:])
        board[i][j] = temp
        return res
