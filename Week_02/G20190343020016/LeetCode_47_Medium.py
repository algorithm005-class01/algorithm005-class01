"""
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


"""

def permuteUnique(nums):
    res = []
    def backtrack(nums, tmp):
        if not nums:
            res.append(tmp)
            return
        arr = []
        for i in range(len(nums)):
            if nums[i] not in arr:
                arr.append(nums[i])
            else:
                continue
            backtrack(nums[:i] + nums[i + 1:], tmp + [nums[i]])
        backtrack(nums, [])
        return res




