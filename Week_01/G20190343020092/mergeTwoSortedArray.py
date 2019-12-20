class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # 输入的nums1只有前m位有效，因此先拷贝出来
        nums1_copy = nums1[:m] 
        nums1[:] = []#清空nums1
        # 两个指针分别遍历两个数组
        p1 = 0 
        p2 = 0
        #遍历时，较小值先放入nums1
        while p1 < m and p2 < n: 
            if nums1_copy[p1] < nums2[p2]: 
                nums1.append(nums1_copy[p1])
                p1 += 1
            else:
                nums1.append(nums2[p2])
                p2 += 1
        #当其中一个数组遍历完后，把另一个数组的剩余部分拼接过去nums1
        if p1 < m: 
            nums1[p1 + p2:] = nums1_copy[p1:]
        if p2 < n:
            nums1[p1 + p2:] = nums2[p2:]
