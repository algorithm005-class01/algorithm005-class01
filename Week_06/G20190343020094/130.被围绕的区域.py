#
# @lc app=leetcode.cn id=130 lang=python3
#
# [130] 被围绕的区域
#
from typing import List

# @lc code=start
class Solution:

    def __init__(self):
        self.x = [1, -1, 0, 0]
        self.y = [0, 0, 1, -1]
    # 开心，将【200.岛屿数量】的解法活学活用在这里
    # DFS解法 时间复杂度O(m*n) 60ms
    def solve(self, board: List[List[str]]) -> None:
        if not board: return 
        m = len(board)
        n = len(board[0])

        def sink(i, j, cur_symbol, chg_symbol):
            if not board: return
            if board[i][j] != cur_symbol: return
            board[i][j] = chg_symbol
            for k in range(len(self.x)):
                x, y = i + self.x[k], j + self.y[k]
                if x >= 0 and x < m and y >= 0 and y < n and board[x][y] == cur_symbol:
                    sink(x, y, cur_symbol, chg_symbol)
        
        # 初始化，将边界的O染色成@，利用flood fill将相连区域染色
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m-1 or j == 0 or j == n-1:
                    if board[i][j] == 'O':
                        sink(i, j, 'O', '@')
        
        # 将其余O区域的变成X,
        # 顺便把@区域变成O
        # for i in range(m):
        #     for j in range(n):
        #         if board[i][j] == 'O':
        #             board[i][j] = 'X'
        #         elif board[i][j] == '@':
        #             board[i][j] = 'O'

        # 下面这个写法更酷欧，相当于
        # for row in board:
        #     for i, c in enumerate(row):
        #         row[i] = 'XO'[c == 'S']
        
        board[:] = [['XO'[c == '@'] for c in row] for row in board]
        # print(board)


# class Solution:
#     def __init__(self):
#         self.x = [1, -1, 0, 0]
#         self.y = [0, 0, 1, -1]

#     # 并查集 340ms
#     def solve(self, board: List[List[str]]) -> None:
#         if not board: return 
#         m = len(board)
#         n = len(board[0])
#         p = [i for i in range(m*n+1)]
#         god_father = m * n

#         def node(i, j):
#             return n * i + j

#         for i in range(m):
#             for j in range(n):
#                 if board[i][j] == 'O':
#                     if i == 0 or i == m-1 or j == 0 or j == n-1:
#                         # 边界初始化，设为同一个爸爸
#                         self.union(p, node(i, j), god_father)             
#                     else:
#                         # 遍历其他节点，找各自的父节点
#                         for k in range(len(self.x)):
#                             x, y = i + self.x[k], j + self.y[k]
#                             if x >= 0 and x < m and y >= 0 and y < n and board[x][y] == 'O':
#                                 self.union(p, node(i, j), node(x, y))
#         # 和边界有同一个祖先的是O，否则X
#         for i in range(m):
#             for j in range(n):
#                 if (self.parent(p, node(i, j)) == self.parent(p, god_father)):
#                     board[i][j] = 'O'
#                 else:
#                     board[i][j] = 'X'
#         # print(board)


#     def union(self, p, i, j): 
#         p1 = self.parent(p, i) 
#         p2 = self.parent(p, j) 
#         # p[p1] = p2
#         p[p1] = p2
    
#     def parent(self, p, i): 
#         root = i 
#         while p[root] != root: 
#             root = p[root] 
#         while p[i] != i: # 路径压缩 ?
#             # 暂存现在的i，找下一个i的父节点，将i的父节点设为最老的祖先节点
#             x = i; i = p[i]; p[x] = root 
#         return root


# @lc code=end

if __name__ == "__main__":
    board = [["O","X","X","O","X"],["X","O","O","X","O"],["X","O","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]
    board = [["O","O","O"],["O","O","O"],["O","O","O"]]
    Solution().solve(board)