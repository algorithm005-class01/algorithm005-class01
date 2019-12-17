# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/merge-sorted-array"""

# 置一pointer从后往前修改数组
from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = n - 1
        p = m + n - 1
        while i >= 0 or j >= 0:
            if i < 0:
                nums1[p] = nums2[j]
                j -= 1
                p -= 1
                continue
            if j < 0:
                break
            if nums1[i] > nums2[j]:
                nums1[p] = nums1[i]
                i -= 1
            else:
                nums1[p] = nums2[j]
                j -= 1
            p -= 1


if __name__ == '__main__':
    nums1 = [1, 3, 5, 7, 9]
    nums1_len = len(nums1)
    nums2 = [2, 4, 5, 8, 10]
    zero_array = [0] * len(nums2)
    nums1.extend(zero_array)
    print(nums1, nums2, sep='\n')
    Solution().merge(nums1, nums1_len, nums2, len(nums2))
    print(nums1)
