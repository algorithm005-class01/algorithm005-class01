class Solution1:
    """
    1） 使用python的语言特性
    """
    def isAnagram(self, s, t):
        return sorted(s) == sorted(t)


from collections import Counter
class Solution2:
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)


class Solution3(object):
    def isAnagram(self, s, t):
        """
        利用字典映射解法的特点是 思路清晰
        """
        if len(s) != len(t):
            return False
        else:
            dic = {}  # 定义一个字典 哈希处理
            for i in s:  # 遍历字符出中的字符 统计每个字符出现的次数 字符为键 频次为值
                if i in dic:
                    dic[i] += 1
                else:
                    dic[i] = 1
            for i in t:  # 遍历 t 中的字符 做对比
                if i in dic:
                    dic[i] -= 1
                else:
                    return False
            for i in dic:  # 检查 字典中 字符频次的值
                if dic[i] != 0:
                    return False
        return True


class Solution4:
    """
    利用字典的 方法和特性 用字典相等的方法，不如用sorted()相等
    """
    def isAnagram(self, s: str, t: str) -> bool:
        dict1 = {}
        dict2 = {}
        for ch in s:
            dict1[ch] = dict1.get(ch, 0) + 1
        for ch in t:
            dict2[ch] = dict2.get(ch, 0) + 1
        return dict1 == dict2



