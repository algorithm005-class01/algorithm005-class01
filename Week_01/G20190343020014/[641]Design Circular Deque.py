#设计实现双端队列。 
#你的实现需要支持以下操作： 
#
# 
# MyCircularDeque(k)：构造函数,双端队列的大小为k。 
# insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
# insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
# deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
# deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
# getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
# getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
# isEmpty()：检查双端队列是否为空。 
# isFull()：检查双端队列是否满了。 
# 
#
# 示例： 
#
# MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
#circularDeque.insertLast(1);			        // 返回 true
#circularDeque.insertLast(2);			        // 返回 true
#circularDeque.insertFront(3);			        // 返回 true
#circularDeque.insertFront(4);			        // 已经满了，返回 false
#circularDeque.getRear();  				// 返回 2
#circularDeque.isFull();				        // 返回 true
#circularDeque.deleteLast();			        // 返回 true
#circularDeque.insertFront(4);			        // 返回 true
#circularDeque.getFront();				// 返回 4
#  
#
# 
#
# 提示： 
#
# 
# 所有值的范围为 [1, 1000] 
# 操作次数的范围为 [1, 1000] 
# 请不要使用内置的双端队列库。 
# 
# Related Topics 设计 队列



#leetcode submit region begin(Prohibit modification and deletion)

class Node:
    def __init__(self, val):
        self.val = val
        self.pre = self.next = None


class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.capacity = k
        self.size = 0
        self.head = self.tail = Node(-1)
        self.head.next = self.tail
        self.tail.pre = self.head

    def _insert(self, head, value):
        new_node, top = Node(value), head.next
        # 连接右边
        new_node.next, top.pre = top, new_node
        # 连接左边
        head.next, new_node.pre = new_node, head
        self.size += 1

    def _del(self, head):
        n = head.next.next
        head.next = n
        n.pre = head
        self.size -= 1

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self._insert(self.head, value)
        return True

    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """

        if self.isFull():
            return False
        self._insert(self.tail.pre, value)
        return True

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self._del(self.head)
        return True

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self._del(self.tail.pre.pre)
        return True

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        return self.head.next.val if self.size > 0 else -1

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        return self.tail.pre.val if self.size > 0 else -1

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        return self.size == 0

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        return self.size >= self.capacity


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
#leetcode submit region end(Prohibit modification and deletion)
