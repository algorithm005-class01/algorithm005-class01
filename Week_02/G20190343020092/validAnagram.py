class Solution:
    #解法一：用两个字典，分别统计两个字符串中的符号数量;遍历完后，比较两个字典是否一致
    时间复杂度：O（N），空间复杂度O（N）
    def isAnagram(self, s: str, t: str) -> bool:
        dict1,dict2 = {},{}
        for item in s:
            dict1[item] = dict1.get(item,0)+1
        for item in t:
            dict2[item] = dict2.get(item,0)+1
        return dict1 == dict2
    
    #解法二：类似的思路，但只用一个字典，遍历S，相应字符统计+1；后遍历T，相应字符统计-1
    #时间复杂度：O（N），空间复杂度O（N）
    def isAnagram(self, s: str, t: str) -> bool:
        dict1 = {}
        for item in s:
            dict1[item] = dict1.get(item,0)+1
        for item in t:
            dict1[item] = dict1.get(item,0)-1
        for i in dict1.values():
            if i != 0:
                return False
        return True
    ##解法二优化代码：S和T如果要是异位词，一定要是等长的，因此两个for循环可以合并，同时加一个长度判断
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        dict1 = {}
        for i in range(len(s)):
            dict1[s[i]] = dict1.get(s[i],0)+1
            dict1[t[i]] = dict1.get(t[i],0)-1
        for j in dict1.values():
            if j != 0:
                return False
        return True
