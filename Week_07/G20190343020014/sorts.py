"""
排序相关
https://mp.weixin.qq.com/s/Qf416rfT4pwURpW3aDHuCg
"""


class SortAlgorithm:

    @classmethod
    def bubble_sort(cls, arr):
        """冒泡排序"""
        i = 0
        while i < len(arr) - 1:
            j = 0
            is_sorted = True
            while j < len(arr) - 1 - i:
                # print(arr, 'i:', i, 'j:', j, " arr[j]:",  arr[j], "arr[j + 1]:", arr[j + 1])
                if arr[j] < arr[j + 1]:
                    temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                    is_sorted = False
                j += 1
            # print(i, is_sorted)
            if is_sorted:
                break
            i += 1
        return arr

    @classmethod
    def select_sort(cls, arr):
        """选择排序：
           首先，找到数组中最小的元素，拎出来，将它和数组的第一个元素交换位置
           第二步，在剩下的元素中继续寻找最小的元素，拎出来，和数组的第二个元素交换位置
           如此循环，直到整个数组排序完成。
        """
        i = 0
        while i < len(arr):
            _min = i # 最小元素下标
            j = i + 1
            while j < len(arr):
                if arr[j] < arr[_min]:
                    _min = j
                j += 1
            if i != _min:
                temp = arr[i]
                arr[i] = arr[_min]
                arr[_min] = temp
            i += 1
        return arr

    @classmethod
    def insert_sort(cls, arr):
        """插入排序
           想象一下摸牌的时候从左往右,从小到大插入
        """
        i = 1  # 从第二个元素开始
        while i < len(arr):
            j = i - 1  # 从i-1开始往前数
            current = i
            while j >= 0:
                # print(current, j, arr)
                if arr[current] < arr[j]:
                    temp = arr[current]
                    arr[current] = arr[j]
                    arr[j] = temp
                    current = j  # 交换后下标要随着一起移动
                else:
                    break
                j -= 1
            i += 1
        return arr

    @classmethod
    def shell_sort(cls, arr):
        """ 希尔排序(发明人叫shell)
            https://www.geeksforgeeks.org/shellsort/

        """
        n = len(arr)
        gap = n // 2
        while gap > 0:
            partb = range(gap, n)
            for i in partb:
                temp = arr[i]
                j = i
                print("gap:{} {} i:{} j:{} j-gap:{} arr[j-gap]>temp:{} > {} arr[j]: {}"
                      .format(gap, partb, i, j, j-gap, arr[j-gap], temp, arr[j]), arr)
                while j >= gap and arr[j - gap] > temp:
                    arr[j] = arr[j - gap]
                    print("\t j:{} j-gap:{} arr[j]=arr[j-gap]:{}={}"
                          .format(j, j - gap, arr[j], arr[j-gap]), arr)
                    j -= gap
                arr[j] = temp
            gap //= 2
        return arr

    @classmethod
    def merge_sort(cls, arr):
        """
        递推公式：
            merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
        终止条件：
            p >= r 不用再继续分解
        """
        # TODO 可改写为递归
        def merge(left, right):
            result = []
            print('合', left, ',', right)
            while left and right:
                min_value = left.pop(0) if left[0] <= right[0] else right.pop(0)
                result.append(min_value)
            # print("\t", "merged", result, "l:", left, 'right', right)
            print("\t", result + left + right)
            return result + left + right

        if len(arr) <= 1:
            return arr
        # print("\t分", arr)
        mid = len(arr) // 2
        lft = arr[:mid]
        r = arr[mid:]

        # print("\t分", lft, ',', r)
        return merge(cls.merge_sort(lft), cls.merge_sort(r))

    @classmethod
    def quick_sort(cls, arr):
        if len(arr) <= 1:
            return arr

        povit = arr.pop()
        left, right = [], []
        for i in arr:
            if i < povit:
                left.append(i)
            else:
                right.append(i)
        return cls.quick_sort(left) + [povit] + cls.quick_sort(right)

    @classmethod
    def quick_sort1(cls, arr):
        pass


if __name__ == '__main__':
    # print(SortAlgorithm.bubble_sort([8, 2, 5, 9, 7, 1]))
    # print(SortAlgorithm.select_sort([8, 2, 5, 9, 7, 1]))
    # print(SortAlgorithm.insert_sort([8, 2, 5, 9, 7, 1]))
    # print(SortAlgorithm.shell_sort([8, 2, 5, 9, 7, 10, 1, 15, 12, 3]))
    # print(SortAlgorithm.merge_sort([8, 2, 5, 9, 7, 10, 1, 15, 12, 3, -1]))
    print(SortAlgorithm.merge_sort([1, 5, 8, 0, 10, 7, 2, 6]))
    # print(SortAlgorithm.quick_sort([8, 2, 5, 9, 7, 10, 1, 15, 12, 3, -1]))
