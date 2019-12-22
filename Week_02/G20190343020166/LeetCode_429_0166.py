"""429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Constraints:

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10^4]
"""


# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        res, q = [], [root]
        #: any(q) can be O(N) operation for another problem if array is like this [None, None, ... , sth].
        # In this problem, "None" can only be placed in zero index and only once, so it's O(1) operation.
        while(any(q)):
            res.append([c.val for c in q])
            q = [child for node in q for child in node if child]
        return res