import collections
from typing import List


class Solution:

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashMap = collections.defaultdict(list)
        for str in strs:
            count = [0] * 26
            for char in str:
                count[ord(char) - ord('a')] += 1
            hashMap[tuple(count)].append(str)
        return hashMap.values()