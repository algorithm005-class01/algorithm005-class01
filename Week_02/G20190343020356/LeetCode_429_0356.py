# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/"""
from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    # 访问本层结点时,将下一层所有结点合并为一个列表,迭代访问
    # 也可以用queue来实现,从而不必每次循环结束都覆盖修改level[]
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        res = []
        level = [root]
        while level:
            next_level = []
            cur_res = []
            for item in level:
                cur_res.append(item.val)
                if item.children:
                    next_level.extend(item.children)
            res.append(cur_res)
            level = next_level
        return res

    """ 使用que
        res = []
        que = [root]
        while que:
            cur_res = []
            for i in range(len(que)):
                cur = que.pop(0)
                cur_res.append(cur.val)
                if cur.children:
                    que.extend(cur.children)
            res.append(cur_res)
        return res
    """
