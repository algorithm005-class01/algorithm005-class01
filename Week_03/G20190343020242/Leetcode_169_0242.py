#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 多数元素
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (60.71%)
# Likes:    389
# Dislikes: 0
# Total Accepted:    93.4K
# Total Submissions: 153.6K
# Testcase Example:  '[3,2,3]'
#
# 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
#
# 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
#
# 示例 1:
#
# 输入: [3,2,3]
# 输出: 3
#
# 示例 2:
#
# 输入: [2,2,1,1,1,2,2]
# 输出: 2
#
#
#
from typing import List

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # # 1. 内置函数，哈希表
        # from collections import Counter
        # most_common = Counter(nums).most_common(1)
        # return most_common[0][0] if most_common[0][1] > len(
        #     nums) // 2 else None

        # 2. 哈希表
        count = {}
        for num in nums:
            count[num] = count.get(num, 0) + 1
            if count[num] > len(nums) // 2:
                return num
        return None

        # 3. TODO: 太慢


# @lc code=end

Solution().majorityElement([3,2,3])