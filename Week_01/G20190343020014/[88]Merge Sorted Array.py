class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # 需要额外空间 O(m)
        # x = nums1[0:m]
        # nums1[:] = []
        # i,j = 0, 0
        # while i < m and j < n:
        #     if x[i] <= nums2[j]:
        #         nums1.append(x[i])
        #         i += 1
        #     else:
        #         nums1.append(nums2[j])
        #         j += 1
        # if i < m:
        #     nums1 += x[i:]
        # if j < n:
        #     nums1 += nums2[j:]

        # 三指针法， 从后往前填， 空间复杂度O(1)
        """
        p = len(nums1) - 1
        m,n = m -1, n -1
        while m >= 0 and n >= 0:
            if nums1[m] > nums2[n]:
                nums1[p] = nums1[m]
                m -= 1
            else:
                nums1[p] = nums2[n]
                n -= 1
            p -= 1
        while n >= 0:
            nums1[n] = nums2[n]
            n -= 1
        """
        # 比较简洁的python 解法
        while m > 0 and n > 0:
            if nums1[m-1] >= nums2[n - 1]:
                nums1[m + n - 1] = nums1[m - 1]
                m -= 1
            else:
                nums1[m + n - 1] = nums2[n - 1]
                n -= 1
        if n > 0:
            nums1[:n] = nums2[:n]