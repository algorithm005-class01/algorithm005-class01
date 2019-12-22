"""
知识点：collection.defaultdict()
使用dict时，如果引用的Key不存在，就会抛出KeyError。
如果希望key不存在时，返回一个默认值，就可以用defaultdict
如果键不存在默认创建一个指定值 下面以 defaultdict（list） 为例
from collections import defaultdict
dd = defaultdict(list)
dd['key1'] = 'name'
dd['key1']
Out[5]: 'name'
dd['key2']
Out[6]: []
####
defaultdict(<class 'list'>, {'key1': 'name', 'key2': []})
"""
import collections


class Solution1(object):
    """
    题型：hash 映射
    思路：sorted("str")为键创建字典的键，默认值为 list
    特征：使用sorted（） 作为hash 函数
    技术处理： sorted("str") 输出为 字符串列表，使用tuple(list)将其固定为可以作为键的 元素
    方法优点：利用 语言特性 一步处理到位 思路清晰
    """
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()


class Solution2:
    """
    题型：hash 映射
    思路：创建哈希函数 检索相应字符串
    技术处理： count[ord(c) - ord('a')] += 1 创建哈希函数
    方法优点：数据量大时相对高效 O（NK） N:字符串数量 K: 每个字符串的长度
    """
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            count = [0] * 26
            # count = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            for c in s:
                count[ord(c) - ord('a')] += 1  # ord('a') 返回 字符'a'对应的ASC码
            ans[tuple(count)].append(s)
        return ans.values()
