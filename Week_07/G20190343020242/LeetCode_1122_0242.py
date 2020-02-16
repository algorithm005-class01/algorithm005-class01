#
# @lc app=leetcode.cn id=1122 lang=python3
#
# [1122] 数组的相对排序
#
# https://leetcode-cn.com/problems/relative-sort-array/description/
#
# algorithms
# Easy (64.36%)
# Likes:    26
# Dislikes: 0
# Total Accepted:    9.3K
# Total Submissions: 14.2K
# Testcase Example:  '[2,3,1,3,2,4,6,7,9,2,19]\n[2,1,4,3,9,6]'
#
# 给你两个数组，arr1 和 arr2，
#
#
# arr2 中的元素各不相同
# arr2 中的每个元素都出现在 arr1 中
#
#
# 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1
# 的末尾。
#
#
#
# 示例：
#
# 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
# 输出：[2,2,2,1,4,3,3,9,6,7,19]
#
#
#
#
# 提示：
#
#
# arr1.length, arr2.length <= 1000
# 0 <= arr1[i], arr2[i] <= 1000
# arr2 中的元素 arr2[i] 各不相同
# arr2 中的每个元素 arr2[i] 都出现在 arr1 中
#
#
#
from typing import List


# @lc code=start
class Solution:

    def relativeSortArray_1(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # 1. 将 arr1 中的元素先按 arr2 中元素计数；将 arr1 不在 arr2 中的剩下的数排序
        buckets = [0] * (len(arr2))
        res = []

        for num in arr1:
            if num not in arr2:
                res.append(num)
            else:
                for j in range(len(arr2)):
                    if arr2[j] == num:
                        buckets[j] += 1

        ans = []
        for j in range(len(buckets)):
            ans.extend([arr2[j]] * buckets[j])
            # while buckets[j] > 0:
            #     ans.append(arr2[j])
            #     buckets[j] -= 1

        ans.extend(sorted(res))
        return ans

    def relativeSortArray_2(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # arr1 计数排序

        counts = [0] * (max(arr1) + 1)
        ans = []

        for num in arr1:
            counts[num] += 1

        for num in arr2:
            ans.extend([num] * counts[num])

        for i in range(len(counts)):
            if i not in arr2:
                ans.extend([i] * counts[i])

        return ans

    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # KEY：简化代码

        k = {num: i for i, num in enumerate(arr2)}
        return sorted(arr1, key=lambda a: k.get(a, a + 1000))


# @lc code=end
