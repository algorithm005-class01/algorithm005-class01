#解法1：python3
from collections import OrderedDict
class LRUCache(OrderedDict):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self:
            return - 1
        
        self.move_to_end(key)
        return self[key]

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self:
            self.move_to_end(key)
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last = False)

#解法2：
class DLinkedNode():
    def __init__(self):
        self.key = 0
        self.value = 0
        self.prev = None
        self.next = None

class LRUCache(object):
    def __add_node(self,node):
        node.pre = self.head
        node.next = self.head.next

        self.head.next.pre = node
        self.head.next = node

    def _remove_node(self,node):
        pre = node.pre
        new = node.next

        pre.next = new
        new.pre = pre

    def _move_to_end(self,node):
        self._remove_node(node)
        self.__add_node(node)
    
    def _pop_tail(self):
        res = self.tail.pre
        self._remove_node(res)
        return res

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cache ={}
        self.size = 0
        self.capacity = capacity
        self.head,self.tail = DLinkedNode(),DLinkedNode()

        self.head.next = self.tail
        self.tail.pre = self.head

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        node = self.cache.get(key,None)
        if not node:
            return -1
        self._move_to_end(node)
        return node.value

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        node = self.cache.get(key)
        if not node:
            newNode = DLinkedNode()
            newNode.key = key
            newNode.value = value
            self.cache[key] = newNode
            self.__add_node(newNode)
            self.size += 1

            if self.size > self.capacity:
                tail = self._pop_tail()
                del self.cache[tail.key]
                self.size -= 1
        else:
            node.value = value
            self._move_to_end(node)      

