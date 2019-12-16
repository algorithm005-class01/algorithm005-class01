def rotate(nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: None Do not return anything, modify nums in-place instead.
    """
    """
    1. O(n*k)
    while k > 0:
        head = nums[-1]
        for i in range(len(nums)-1, 0, -1):
            nums[i] = nums[i-1]
        nums[0] = head
        k = k - 1
    return nums

    2. O(n)
    temp = [0 for x in range(len(nums))]
    for i in range(len(nums)):
        temp[(i+k)%len(nums)] = nums[i]

    for i in range(len(nums)):
        nums[i] = temp[i]
    return nums
    """

    k %= len(nums)
    nums[:] = nums[::-1]
    nums[:k] = nums[:k][::-1]
    nums[k:] = nums[k:][::-1]
    return nums


if __name__ == '__main__':
    print(rotate([1, 2, 3, 4, 5, 6, 7], 3))
