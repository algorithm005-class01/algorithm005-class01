# -*- coding: utf-8 -*-


class LRUCache(object):
    def __init__(self, capacity=None):
        self.capacity = capacity
        self.cache = dict()
        self.head = None
        self.tail = None

    def get(self, key):
        value = self.cache.get(key)
        if value:
            value.prev.next = value.next
            value.next