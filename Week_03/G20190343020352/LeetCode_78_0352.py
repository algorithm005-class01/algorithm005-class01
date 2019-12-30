from typing import List


class Solution(object):

    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            newsets = []
            for subset in result:
                new_subset = subset + [num]
                newsets.append(new_subset)
            result.extend(newsets)
        return result

    def subsets2(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            result.extend([[num] + subset for subset in result])
        return result
