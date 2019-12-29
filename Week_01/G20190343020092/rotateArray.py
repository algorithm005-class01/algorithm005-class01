class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #观察可以发现，反转k步，其实就是把数组的末K位的元素挪到数组前K位，原来0到k-1位，放到末k位；切片即可简洁地完成。
        #时间复杂度0（n），因为完成了数组的拼接
        n = len(nums)
        k %= n
        nums[:] = nums[-k:] + nums[:-k]
