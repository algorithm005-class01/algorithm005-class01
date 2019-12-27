# 解法1：排序
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        s, t = s.lower(), t.lower()
        
        return sorted(s) == sorted(t)

# 解法2：计数法+哈希表，判断条件是计数为0
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        s, t = s.lower(), t.lower()
        if s == t:
            return True
        dic ={}
        for i in s:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
        for i in t:
            if i in dic:
                dic[i] -= 1
            else:
                return False
            
        for i in dic:
            if dic[i] != 0:
                return False
        return True



#解法2 调用模块：collections
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        s, t = s.lower(), t.lower()
        if s == t:
            return True
        
        return collections.Counter(s) == collections.Counter(t)

#解法3：计数法，字母总数相等
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        hashmap ={}
        if s == t:
            return True
        if len(s) != len(t):
            return False

        for c in s:
            hashmap[c] = s.count(c)
            if c not in t or hashmap[c] != t.count(c):
                return False
        return True

#解法4：计数法，set 去重字符
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        result = True
        s, t = s.lower(), t.lower()
        if s == t:
            return True
        set_s = set(s)
        if set_s == set(t):
            for i in set_s:
                result = result and (s.count(i) == t.count(i))
        else:
            result = False
        return result
