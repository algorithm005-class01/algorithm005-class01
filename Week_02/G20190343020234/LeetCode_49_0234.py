import collections

class Solution:
    def groupAnagrams(self, strs):
        # res = collections.defaultdict(list)
        # for s in strs:
        #     count = [0] * 26
        #     for c in s:
        #         count[ord(c) - ord('a')] += 1
        #     res[tuple(count)].append(s)
        # return res.values()
        res = collections.defaultdict(list)
        for s in strs:
            res[tuple(sorted(s))].append(s)
        return res.values()


if __name__ == "__main__":
    solu = Solution()
    print(solu.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
