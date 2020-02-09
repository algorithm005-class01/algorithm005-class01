#解法1：
class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        diff = [a for a in arr1 if a not in arr2]
        diff = sorted(diff)
        res = []
        for a in arr2:
            res += [a for _ in range(arr1.count(a))]
        res += diff
        return res

#解法2：
class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        dic = {}
        for elem in arr1:
            if dic.get(elem,None):
                dic[elem] += 1
            else:
                dic[elem] = 1
        output = []
        for elem in arr2:
            output += [elem] * dic[elem]
        extra_output = []
        for elem in set(arr1) - set(arr2):
            extra_output +=[elem] * dic[elem]
        return output + sorted(extra_output)


#解法3：
class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        arr2 += sorted(set(arr1)-set(arr2))
        arr1.sort(key=arr2.index)
        return arr1
