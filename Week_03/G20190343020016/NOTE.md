学习笔记


def binary_search(list, item):
    '''
    :param list: 有序列表
    :param item: 要查找的元素
    :return: item在list中的索引，若不在list中返回None
    '''
    low = 0
    high = len(list) - 1
    while low <= high:
        midpoint = (low + high) // 2
        if list[midpoint] == item:
            return midpoint
        elif list[midpoint] < item:
            low = midpoint + 1
        elif list[midpoint] > item:
            high = midpoint - 1
    return None





