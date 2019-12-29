class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i,j,k = 0,0,0
        nums1_copy = nums1[0:m].copy()

        while (i<m and j<n):
            if nums1_copy[i] > nums2[j]:
                nums1[k] = nums2[j]            
                j+=1
            else:
                nums1[k] = nums1_copy[i]
                i+=1
            k+=1
        if i==m:
            nums1[k:m+n] = nums2[j:]
        else:
            nums1[k:m+n] = nums1_copy[i:]