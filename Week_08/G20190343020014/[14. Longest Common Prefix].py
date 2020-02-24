\
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs: return ""
        head = strs[0]
        if len(strs) == 1: return head
        rs = ""
        for idx, s in enumerate(list(head)):
            # print(idx, s, strs[1:])
            for x in strs[1:]:
                # print(len(x), x[idx])
                if len(x) <= idx or x[idx] != s:
                    return rs
            rs += s
        return rs
