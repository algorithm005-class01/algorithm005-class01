#
# @lc app=leetcode.cn id=773 lang=python3
#
# [773] 滑动谜题
#
# https://leetcode-cn.com/problems/sliding-puzzle/description/
#
# algorithms
# Hard (55.53%)
# Likes:    38
# Dislikes: 0
# Total Accepted:    1.4K
# Total Submissions: 2.4K
# Testcase Example:  '[[1,2,3],[4,0,5]]'
#
# 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
#
# 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
#
# 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
#
# 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
#
# 示例：
#
#
# 输入：board = [[1,2,3],[4,0,5]]
# 输出：1
# 解释：交换 0 和 5 ，1 步完成
#
#
#
# 输入：board = [[1,2,3],[5,4,0]]
# 输出：-1
# 解释：没有办法完成谜板
#
#
#
# 输入：board = [[4,1,2],[5,0,3]]
# 输出：5
# 解释：
# 最少完成谜板的最少移动次数是 5 ，
# 一种移动路径:
# 尚未移动: [[4,1,2],[5,0,3]]
# 移动 1 次: [[4,1,2],[0,5,3]]
# 移动 2 次: [[0,1,2],[4,5,3]]
# 移动 3 次: [[1,0,2],[4,5,3]]
# 移动 4 次: [[1,2,0],[4,5,3]]
# 移动 5 次: [[1,2,3],[4,5,0]]
#
#
#
# 输入：board = [[3,2,4],[1,5,0]]
# 输出：14
#
#
# 提示：
#
#
# board 是一个如上所述的 2 x 3 的数组.
# board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
#
#
#
from typing import List


# @lc code=start
class Solution:

    def slidingPuzzle_1(self, board: List[List[int]]) -> int:
        # 1. BFS
        from collections import deque

        start = tuple(num for num_list in board for num in num_list)

        queue = deque([(start, start.index(0), 0)])
        seen = {start}

        target = (1, 2, 3, 4, 5, 0)
        next = [(1, 3), (0, 2, 4), (1, 5), (0, 4), (1, 3, 5),
                (2, 4)]     # next[i] 表示 0 在索引 i 时，可移动到的位置

        while queue:
            board, posn, depth = queue.popleft()
            if board == target:
                return depth
            for nei in next[posn]:
                newboard = list(board)
                newboard[posn], newboard[nei] = newboard[nei], newboard[posn]
                newt = tuple(newboard)
                if newt not in seen:
                    seen.add(newt)
                    queue.append((newt, nei, depth + 1))

        return -1

    def slidingPuzzle(self, board: List[List[int]]) -> int:
        # 2. A* search
        # FIXME:

        start = tuple(num for num_list in board for num in num_list)

        pqueue = PriorityQueue([(start, start.index(0), 0)])
        seen = {start}

        target = (1, 2, 3, 4, 5, 0)
        next = [(1, 3), (0, 2, 4), (1, 5), (0, 4), (1, 3, 5),
                (2, 4)]     # next[i] 表示 0 在索引 i 时，可移动到的位置

        while pqueue:
            board, posn, depth = pqueue.pop()
            if board == target:
                return depth
            for nei in next[posn]:
                newboard = list(board)
                newboard[posn], newboard[nei] = newboard[nei], newboard[posn]

                priority = heuristic(board)
                newt = tuple(newboard)
                if newt not in seen:
                    seen.add(newt)
                    pqueue.add((newt, nei, depth + 1),priority=priority)

        return -1


def heuristic(board):
    # 每个数字在的位置与其应当在的位置间的曼哈顿距离之和
    ans = 0
    R, C = 2, 3
    expected = {(C * r + c + 1) % (R * C): (r, c) for r in range(R) for c in range(C)}

    for r in range(R):
        for c in range(C):
            val = board[C * r + c]
            if val == 0:
                continue
            er, ec = expected[val]
            ans += abs(r - er) + abs(c - ec)
    return ans


from heapq import heappush, heappop


class PriorityQueue:

    def __init__(self, iterable=[]):
        self.heap = []
        for value in iterable:
            heappush(self.heap, (0, value))

    def add(self, value, priority=0):
        heappush(self.heap, (priority, value))

    def pop(self):
        priority, value = heappop(self.heap)
        return value

    def __len__(self):
        return len(self.heap)

    def __repr__(self):
        return f"{self.heap}"


# @lc code=end

board = [[1, 2, 3], [4, 0, 5]]
Solution().slidingPuzzle(board)
