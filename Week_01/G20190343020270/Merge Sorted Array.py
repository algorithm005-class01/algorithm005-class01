# 88. Merge Sorted Array

# Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

# Note:

# The number of elements initialized in nums1 and nums2 are m and n respectively.
# You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
# Example:

# Input:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3

# Output: [1,2,2,3,5,6]

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        # n = len(nums2)
        # m = len(nums1)
        # for i in range(n):
        #     for j in range(m):
        #         if nums[j] < nums[i] < nums[j+1]
        
        # 双指针 从前往后 O(m+n) O(m)
#         nums1Copy = nums1[:m]
#         nums1[:] = []
        
#         p1 = 0
#         p2 = 0
        
#         while p1 < m and p2 < n:
#             if nums1Copy[p1] <= nums2[p2]:
#                 nums1.append(nums1Copy[p1])
#                 p1 += 1
#             else:
#                 nums1.append(nums2[p2])
#                 p2 += 1
#         if p1 < m:
#             nums1[p1+p2:] = numsCopy[p1:]
#         if p2 < n:
#             nums1[p1+p2:] = nums2[p2:]
            
        # 双指针 从后往前
        p1 = m - 1
        p2 = n - 1
        p = m + n - 1
        
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
            else:
                nums1[p] = nums1[p1]
                p1 -= 1
            p -= 1
        nums1[:p2+1] = nums2[:p2+1]