# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/lru-cache/"""

"""
class collections.OrderedDict([items])
返回一个 dict 子类的实例，它具有专门用于重新排列字典顺序的方法。
popitem(last=True)
有序字典的 popitem() 方法移除并返回一个 (key, value) 键值对。 
如果 last 值为真，则按 LIFO 后进先出的顺序返回键值对，否则就按 FIFO 先进先出的顺序返回键值对。

move_to_end(key, last=True)
将现有 key 移动到有序字典的任一端。 
如果 last 为真值（默认）则将元素移至末尾；
如果 last 为假值则将元素移至开头。如果 key 不存在则会触发 KeyError:
"""

from collections import OrderedDict

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.order_dict = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.order_dict:
            return -1
        self.order_dict.move_to_end(key)
        return self.order_dict[key]

    def put(self, key: int, value: int) -> None:
        if len(self.order_dict) < self.capacity or key in self.order_dict:
            self.order_dict[key] = value
            self.order_dict.move_to_end(key)
            return None
        self.order_dict.popitem(last=False)
        self.order_dict[key] = value