#暴力法 遍历 用""替换 "()""[]""{}"

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s == "" :
            return True
        n = len(s)
        if n % 2 == 1:
            return False
        x = int(n/2)
        for i in range(x):
            s = s.replace("()","")
            s = s.replace("[]","")
            s = s.replace('{}',"")
        return s == ""

#栈的办法，一对匹配，就弹出元素，不匹配就是错的
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s == "" :
            return True
        n = len(s)
        if n % 2 == 1:
            return False
        d = {")":"(","}":"{","]":"[","?":"?"}
        stack = ["?"]
        for i in s :
            if i not in d:
                stack.append(i)
            elif d[i] != stack.pop():
                return False
        return stack == ["?"]

#栈，但是不用字典
class Solution:
    def isValid(self, s):
        stack = []
        for char in s:
            if char == "(" or char == "{" or char == "[":
                stack.append(char) 
            elif len(stack) <= 0:
                return False
            elif char == ")" and stack.pop() != "(":
                return False
            elif char == "]" and stack.pop() != "[":
                return False
            elif char == "}" and stack.pop() != "{":
                return False
        if len(stack) == 0:
            return True
        return False
