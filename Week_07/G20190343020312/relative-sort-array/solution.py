class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        res = []
        for i in arr2:
            while i in arr1:
                res.append(i)
                arr1.remove(i)
        return res + sorted(arr1)

