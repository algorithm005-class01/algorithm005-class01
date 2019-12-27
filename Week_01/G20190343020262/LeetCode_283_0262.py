from typing import List

#数组不要使用删除或者插入操作，想办法做替换设值操作
def moveZeros(nums: List[int]) -> List[int]:
    notZeroIndex = 0
    for num in nums:
        if num != 0:
            nums[notZeroIndex] = num
            notZeroIndex += 1
    for i  in range(notZeroIndex, len(nums)):
        nums[i] = 0
    return nums

def moveZerosIndex(nums: List[int]) -> List[int]:
    notZeroIndex = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[notZeroIndex] = nums[i]
            if i != notZeroIndex:
                nums[i] = 0
            notZeroIndex += 1
    return nums

#python语言表达式使程序更加简单
def moveZerosOneLineCode(nums: List[int]) -> List[int]:
    nums[:] = [x for x in nums if x != 0]  +  [x for x in nums if x == 0]
    return nums

moveZeros([0,1,0,3,12])
moveZerosIndex([0,1,0,3,12])
moveZerosOneLineCode([0,1,0,3,12])
