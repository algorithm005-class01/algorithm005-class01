#
# @lc app=leetcode.cn id=1091 lang=python3
#
# [1091] 二进制矩阵中的最短路径
#
# https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/description/
#
# algorithms
# Medium (26.89%)
# Likes:    15
# Dislikes: 0
# Total Accepted:    2.5K
# Total Submissions: 9.2K
# Testcase Example:  '[[0,1],[1,0]]'
#
# 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
#
# 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
#
#
# 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
# C_1 位于 (0, 0)（即，值为 grid[0][0]）
# C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
# 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
#
#
# 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
#
#
#
# 示例 1：
#
# 输入：[[0,1],[1,0]]
#
# 输出：2
#
#
#
# 示例 2：
#
# 输入：[[0,0,0],[1,1,0],[1,1,0]]
#
# 输出：4
#
#
#
#
#
# 提示：
#
#
# 1 <= grid.length == grid[0].length <= 100
# grid[i][j] 为 0 或 1
#
#
#
from typing import List


# @lc code=start
class Solution:

    def shortestPathBinaryMatrix_1(self, grid: List[List[int]]) -> int:
        # 1. BFS
        if grid[0][0] == 1 or grid[-1][-1] == 1:
            return -1

        n = len(grid)
        state = [(0, 0, 1)]     # 位置 i/j、步数 d
        for i, j, d in state:     # KEY：state 在迭代过程中也在变化！！！
            if i == n - 1 and j == n - 1:
                return d
            for x, y in ((i - 1, j - 1), (i - 1, j), (i - 1, j + 1), (i, j - 1), (i, j + 1),
                         (i + 1, j - 1), (i + 1, j), (i + 1, j + 1)):
                if 0 <= x < n and 0 <= y < n and not grid[x][y]:
                    grid[x][y] = 1
                    state.append((x, y, d + 1))
        return -1

    def shortestPathBinaryMatrix(self, grid):
        # 2. A* search

        shortest_path = a_star_graph_search(
            start=(0, 0),
            goal_function=get_goal_function(grid),
            successor_function=get_successor_function(grid),
            heuristic=get_heuristic(grid))
        if shortest_path is None or grid[0][0] == 1:
            return -1
        else:
            return len(shortest_path)


def a_star_graph_search(start, goal_function, successor_function, heuristic):
    # 当前点时给下一步可走的点一个优先级权重，权重为：已走的步数 + 该点与终点的 x/y轴间距较大者
    # 优先选择权重较小的点作为下一个点

    visited = set()
    came_from = dict()
    distance = {start: 0}     # 点对应的走过的步数

    frontier = PriorityQueue(iterable=[start])

    while frontier:
        node = frontier.pop()
        if node in visited:
            continue
        if goal_function(node):
            return reconstruct_path(came_from, start, node)
        visited.add(node)
        for successor in successor_function(node):
            frontier.add(successor, priority=distance[node] + 1 + heuristic(successor))
            if (successor not in distance or distance[node] + 1 < distance[successor]):
                distance[successor] = distance[node] + 1
                came_from[successor] = node
    return None


def reconstruct_path(came_from, start, end):
    """
    >>> came_from = {'b': 'a', 'c': 'a', 'd': 'c', 'e': 'd', 'f': 'd'}
    >>> reconstruct_path(came_from, 'a', 'e')
    ['a', 'c', 'd', 'e']
    """
    reverse_path = [end]
    while end != start:
        end = came_from[end]
        reverse_path.append(end)
    return list(reversed(reverse_path))


def get_goal_function(grid):
    """
    >>> f = get_goal_function([[0, 0], [0, 0]])
    >>> f((0, 0))
    False
    >>> f((0, 1))
    False
    >>> f((1, 1))
    True
    """
    M = len(grid)
    N = len(grid[0])

    def is_bottom_right(cell):
        return cell == (M - 1, N - 1)

    return is_bottom_right


def get_successor_function(grid):
    """
    >>> f = get_successor_function([[0, 0, 0], [0, 1, 0], [1, 0, 0]])
    >>> sorted(f((1, 2)))
    [(0, 1), (0, 2), (2, 1), (2, 2)]
    >>> sorted(f((2, 1)))
    [(1, 0), (1, 2), (2, 2)]
    """

    def get_clear_adjacent_cells(cell):
        i, j = cell
        return ((i + a, j + b) for a in (-1, 0, 1) for b in (-1, 0, 1) if a != 0 or b != 0
                if 0 <= i + a < len(grid) if 0 <= j + b < len(grid[0])
                if grid[i + a][j + b] == 0)

    return get_clear_adjacent_cells


def get_heuristic(grid):
    """
    >>> f = get_heuristic([[0, 0], [0, 0]])
    >>> f((0, 0))
    1
    >>> f((0, 1))
    1
    >>> f((1, 1))
    0
    """
    M, N = len(grid), len(grid[0])
    (a, b) = goal_cell = (M - 1, N - 1)

    def get_clear_path_distance_from_goal(cell):
        (i, j) = cell
        return max(abs(a - i), abs(b - j))

    return get_clear_path_distance_from_goal


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

grid = [[0, 0, 0, 1, 0, 0, 1, 0], [0, 0, 0, 0, 0, 0, 0, 0], [1, 0, 0, 1, 1, 0, 1, 0],
        [0, 1, 1, 1, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1, 1, 1], [1, 0, 1, 0, 0, 0, 0, 0],
        [1, 1, 0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 0, 1, 0, 0]]
Solution().shortestPathBinaryMatrix_2(grid)