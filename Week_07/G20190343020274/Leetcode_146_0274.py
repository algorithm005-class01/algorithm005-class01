#!/user/bin/python
#-*- coding:utf-8 -*-
import collections

#Design and implement a data structure for Least Recently Used (LRU) cache. 
#It should support the following operations: get and put.
class LRUCache:

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.orderdict = collections.OrderedDict()
        self.remain = capacity
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if not key in self.orderdict:
            return -1
        value = self.orderdict[key]
        self.orderdict.pop(key)
        self.orderdict[key] = value
        return value
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self.orderdict:
            self.orderdict.pop(key)
        else:
            if self.remain > 0:
                self.remain -= 1
            else:
                self.orderdict.popitem(last=False)
        self.orderdict[key] = value    



import unittest
class LRUCacheTestCase(unittest.TestCase):
    def testCaseLRUCache(self): 
        cache = LRUCache(2)
        cache.put(1, 1);
        cache.put(2, 2);
        self.assertTrue(cache.get(1) == 1)
        cache.put(3, 3)
        self.assertTrue(cache.get(2) == -1)
        cache.put(4, 4)
        self.assertTrue(cache.get(1) == -1)
        self.assertTrue(cache.get(3) == 3)
        self.assertTrue(cache.get(4) == 4)

    def testCaseLRUCache1(self): 
        cache = LRUCache(2)
        cache.put(2, 1);
        cache.put(2, 2);
        self.assertTrue(cache.get(2) == 2)



if __name__ == "__main__" : unittest.main()