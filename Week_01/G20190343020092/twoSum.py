class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        myDict = {}
        for i,v in enumerate(nums):
            myDict[v] = i
        for index1,num in enumerate(nums):
            index2 = myDict.get(target - num)
            if index2 is not None and index2 != index1:
                return [index1,index2]

#区别于暴力法，先一次遍历，生成value : index的字典，空间复杂度O(n)，时间复杂度O(n)
#之后第二次遍历，寻找myDict[target-num]是否存在于字典中，如果存在且不是当前遍历的元素(题目要求不能重复利用同一个元素)，则返回结果
