#给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
#
# 示例: 
#
# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
#输出:
#[
#  ["ate","eat","tea"],
#  ["nat","tan"],
#  ["bat"]
#] 
#
# 说明： 
#
# 
# 所有输入均为小写字母。 
# 不考虑答案输出的顺序。 
# 
# Related Topics 哈希表 字符串


from typing import List
#leetcode submit region begin(Prohibit modification and deletion)

import collections
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = collections.defaultdict(list)
        for s in strs:
            result[tuple(sorted(s))].append(s)
        return result.values()


# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         ans = collections.defaultdict(list)
#         for s in strs:
#             count = [0] * 26
#             for c in s:
#                 count[ord(c) - ord('a')] += 1
#             ans[tuple(count)].append(s)
#         return ans.values()

#leetcode submit region end(Prohibit modification and deletion)
r = Solution().groupAnagrams(["eat","tea","tan","ate","nat","bat"])
print(r)