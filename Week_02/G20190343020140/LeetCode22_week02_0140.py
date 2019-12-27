#解法一：动态规划
class Solution(object):   
    def generateParenthesis(self, n): #先确定一对括号，新生成的括号，只要可能在该对括号的内部和外部， 所以只有n-1对括号会生成， 两组括号的排列组合，就是最终括号的可能结果
        """
        :type n: int
        :rtype: List[str]
        """
        dp = [[] for _ in range(n+1)]    #dp[i] 存放第i组括号所在的有效组合
        dp[0] = [""]
        for i in range(1,n+1):
            for p in range(i):         
                l1 = dp[p]                #第p 个组合
                l2 = dp[i-1-p]            #第i-1-p 个组合
                for k1 in l1:
                    for k2 in l2:
                        dp[i].append("({0}){1}".format(k1,k2))
        return dp[n]


#解法二：排列组合+数学归纳法
class Solution(object):
    def generateParenthesis(self, n): #先确定一对括号，新生成的括号，只要可能在该对括号的内部和外部， 所以只有n-1对括号会生成， 两组括号的排列组合，就是最终括号的可能结果
        """
        :type n: int
        :rtype: List[str]
        """
        if n == 0:
            return []
        total_l = []
        total_l.append([""])   #0组
        total_l.append(["()"])  #1组
        for i in range(2,n+1):  #开始计算组括号是的括号组合
            l = []
            for j in range(i):   #开始遍历， i+j = n-1,  j 作为索引
                now_list1 = total_l[j]     #  为j 时括号的组合
                now_list2 = total_l[i-1-j]  #为 i-1-j 时括号的组合
                for k1 in now_list1:
                    for k2 in now_list2:
                        #if k1 == None:
                        #    k1 = ''
                        #if k2 == None:
                        #    k2 = ''
                        el = "(" + k1 +")" + k2
                        l.append(el)        #把可能的情况添加进 l
            total_l.append(l)         #i 组括号的所有情况添加到total_l 中，继续求解i = i+1
        return total_l[n]

#解法3 递归
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n == 0:
            return [""]                                     
        ans = []                                       
        for c in xrange(n):                                   #先确定一对括号，新生成的括号，只要可能在该对括号的内部和外部， 所以只有n-1对括号会生成， 两组括号的排列组合，就是最终括号的可能结果
            for left in self.generateParenthesis(c):          #0 到 c 遍历
                for right in self.generateParenthesis(n-1-c):  #n-1 到 0 遍历
                    ans.append("({0}){1}".format(left,right))
        return ans
    
#解法4 回溯法
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        def backtrack(s = "", left = 0, right = 0):       
            if len(s) == 2 * n:
                ans.append(s)
                return 
            if left < n:                           #枚举到n个左括号
                backtrack(s + "(",left + 1,right)
            if right < left:                      #同时右括号的数目小于等于左括号
                backtrack(s + ")",left,right + 1)
        backtrack()
        return ans

#解法5，暴力枚举所有的可能
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def generate(A = []):           #生成括号
            if len(A) == 2 * n:     
                if valid(A):            #左右括号数量匹配就添加进ans
                    ans.append("".join(A))

            else:
                A.append("(")          #"（" "）"括号各生成了2n 次
                generate(A)            
                A.pop()                #多出一个“）”就要减少一个“（”
                A.append(")")
                generate(A)
                A.pop()
        
        def valid(A):      #左右括号数量相等
            bal = 0
            for c in A:
                if  c == "(":
                    bal += 1
                else:
                    bal -= 1
                if bal < 0:
                    return False
            return bal == 0
        
        ans = []
        generate()
        return ans
