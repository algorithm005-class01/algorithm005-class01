#给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
#
# 说明：解集不能包含重复的子集。 
#
# 示例: 
#
# 输入: nums = [1,2,3]
#输出:
#[
#  [3],
#  [1],
#  [2],
#  [1,2,3],
#  [1,3],
#  [2,3],
#  [1,2],
#  []
#] 
# Related Topics 位运算 数组 回溯算法


from typing import List
#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """套用回溯模板"""
        def backtracking(path, choice):
            res.append(path[:])
            print(path, '->', choice)
            for idx, v in enumerate(choice):
                if v in path:
                    continue
                path.append(v)
                # print('-->', i, choice[1: len(choice)])
                backtracking(path, choice[idx: len(choice)])
                path.pop()
        res = []
        backtracking([], nums)
        print(res)
        return res


class Solution1:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """回溯优化"""
        def backtracking(path, i):
            res.append(path[:])
            for j in range(i, len(nums)):
                backtracking(path + [nums[j]], j + 1)

        res = []
        backtracking([], 0)
        return res


#leetcode submit region end(Prohibit modification and deletion)
a = Solution().subsets([1, 2, 3])
b = Solution1().subsets([1, 2, 3])
assert a == b
print(b)