# -*- coding: utf-8 -*-


class LRUCache(object):
    def __init__(self, capacity=None):
        self.capacity = capacity
        self.cache = dict()
        self.head = self.DoubleLinkNode()
        self.tail = self.DoubleLinkNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key):
        value = self.cache.get(key)
        if value:
            self.move_to_head(value)
            return value.value
        return -1

    def put(self, key, value):
        v = self.cache.get(key)
        if v:
            # 如果cache中已经存在，则更新数据
            v.value = value
            self.cache[key] = v
            self.move_to_head(v)
        else:
            # 如果cache中不存在
            if len(self.cache) >= self.capacity:
                # 超出cache长度，删除最旧的key
                deleted_value = self.pop_from_tail()
                self.cache.pop(deleted_value.key)
            # 压入新key
            new_value = self.DoubleLinkNode(key, value)
            self.put_from_head(new_value)
            self.cache[key] = new_value

    def move_to_head(self, value):
        if value == self.head:
            return
        value.next.prev = value.prev
        value.prev.next = value.next
        self.put_from_head(value)

    def pop_from_tail(self):
        deleted_value = self.tail.prev

        self.tail.prev = deleted_value.prev
        deleted_value.prev.next = self.tail

        return deleted_value

    def put_from_head(self, value):
        value.next = self.head.next
        value.next.prev = value
        value.prev = self.head
        self.head.next = value

    class DoubleLinkNode(object):
        def __init__(self, k=None, v=None):
            self.next = None
            self.prev = None
            self.key = k
            self.value = v


if __name__ == '__main__':
    cache = LRUCache(3)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)
    cache.put(4, 4)
    print(cache.get(4))
    print(cache.get(3))
    print(cache.get(2))
    print(cache.get(1))
    cache.put(5, 5)
    print(cache.get(1))
    print(cache.get(2))
    print(cache.get(3))
    print(cache.get(4))
    print(cache.get(5))

    ["LRUCache", "put", "put", "put", "put", "get", "get", "get", "get", "put", "get", "get", "get", "get", "get"]
    [[3], [1, 1], [2, 2], [3, 3], [4, 4], [4], [3], [2], [1], [5, 5], [1], [2], [3], [4], [5]]