#给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
#
# 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
#
# 示例 1: 
#
# 输入: [3,2,3]
#输出: 3 
#
# 示例 2: 
#
# 输入: [2,2,1,1,1,2,2]
#输出: 2
# 
# Related Topics 位运算 数组 分治算法


from typing import List
#leetcode submit region begin(Prohibit modification and deletion)

# hash
class Solution:
    def majorityElement1(self, nums: List[int]) -> int:
        counter = {}
        for n in nums:
            counter[n] = counter.get(n, 0) + 1
        v = len(nums) // 2
        for c in counter:
            if counter.get(c) > v:
                return c

    def majorityElement2(self, nums: List[int]) -> int:
        from collections import Counter
        v = len(nums) // 2
        counter = Counter(nums)
        for c in counter:
            if counter.get(c) > v:
                return c

    # hash 优化
    def majorityElement3(self, nums: List[int]) -> int:
        counter = {}
        p = len(nums) // 2
        for n in nums:
            c = counter.get(n, 0) + 1
            if c > p:
                return n
            counter[n] = c

    # 排序
    def majorityElement4(self, nums: List[int]) -> int:
        return sorted(nums)[len(nums) // 2]

    # Boyer Moore Vote Algorithm
    def majorityElement(self, nums: List[int]) -> int:
        count, group = 1, nums.pop(0)
        for n in nums:
            if count == 0:
                count += 1
                group = n
            elif n == group:
                count += 1
            else:
                count -= 1
        return group

#leetcode submit region end(Prohibit modification and deletion)

x = Solution().majorityElement([3,2,3])
assert x == 3