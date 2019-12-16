#解法1：不同步栈，栈只存最小值，弹出操作要判断弹出的元素是不是最小值，不是就不用操作，如果是栈顶元素要弹出
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.data.append(x)
        if not self.stack or x <= self.stack[-1]:
            self.stack.append(x)

    def pop(self):
        """
        :rtype: None
        """
        if self.data:
            pop_temp = self.data.pop()
            if self.stack and pop_temp == self.stack[-1]: #pop操作检查栈空的情况
                self.stack.pop()
            return pop_temp

    def top(self):
        """
        :rtype: int
        """
        if self.data:
            return self.data[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1]


#解法2：同步栈，每次存最小值，如果没有最小值，就再把原来的最小值存一遍，保证data 和stack大小一样
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.data.append(x)
        if not self.stack or x <= self.stack[-1]:
            self.stack.append(x)
        else:
            self.stack.append(self.stack[-1])
    def pop(self):
        """
        :rtype: None
        """
        if self.data:
            pop_temp = self.data.pop()
            
            return self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        if self.data:
            return self.data[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1]


#解法3：用一个栈和一个min， min 存储最小值，空间复杂度O(1)
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = min               #栈内存最小值

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if not self.stack:                  #栈空
            
            self.min = x                    #两者相减，更新min值，最后存的是0
            self.stack.append(x-self.min)   
        else:
            self.stack.append(x-self.min)  #站内存差值
            if x< self.min:                #新来的元素比栈顶的元素小，更新最小值
                self.min = x       

    def pop(self):
        """
        :rtype: None
        """
        if self.stack:
            pop_temp = self.stack.pop()      #弹出元素
            if pop_temp<0:                  #弹出的元素是负值，代表当前min 是最小值，但是它的前一个值比他大，所以要更新min值
                self.min -= pop_temp        #新的最小值是 最小值减去弹出元素
            
            return self.min+pop_temp        #原栈顶元素等于 最小值+弹出元素


    def top(self):
        """
        :rtype: int
        """
        if self.stack:
            if self.stack[-1] <0:           #弹出为负值，说明该值最小，最小值就是弹出元素
                return self.min                      
            else:
                return self.min + self.stack[-1]  #弹出为正值，最小值+弹出元素

    def getMin(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.min 
