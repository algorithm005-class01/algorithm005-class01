def remove_duplicates(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    i = 0
    for j in range(1, len(nums)):
        if nums[i] != nums[j]:
            nums[i+1] = nums[j]
            i += 1
    return i+1


if __name__ == '__main__':
    print(remove_duplicates([1, 1, 2]))
