class Solution:
    # 双指针滑动
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s) or not p: return []
        start, end, result, pdict = 0, 0, [], {}
        for i in p:
            pdict[i] = pdict.get(i, 0) + 1
        temp = {}
        while end <= len(s):
            print(start, end)
            if end - start == len(p):
                # 判断是否满足条件
                print('\t', start, end, temp)
                flag = True
                for k in temp:
                    if temp[k] != pdict.get(k, -1):
                        flag = False
                        break
                if flag:
                    result.append(start)
                # 已经到底
                if end == len(s):
                    break

                # 往后移动
                if temp[s[start]] == 1:
                    del temp[s[start]]
                else:
                    temp[s[start]] = temp.get(s[start]) - 1
                start += 1
                # 往后移动
                # start += 1
                # end = start
                # temp = {}
            temp[s[end]] = temp.get(s[end], 0) + 1
            end += 1
        return result
