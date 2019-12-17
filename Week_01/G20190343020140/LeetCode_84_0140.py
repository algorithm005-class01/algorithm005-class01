#解法1 栈
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        stack =[-1]                            #初始化栈，不为空
        max_area = 0
        heights.append(0)                   #末尾加0，使得原数组中的最后一个元素可以计算。

        for i in range(len(heights)):               #建立单调递增栈
            while heights[i] < heights[stack[-1]]:  #新进来的值如果比栈顶元素小就弹出栈顶元素
                h = heights[stack.pop()]            #高度就是栈顶柱子A的高度  
                w = i - (stack[-1] + 1)             #有边沿正好是i，左边沿：单调栈中近邻栈顶的柱子，（如果A已经出栈，那么左边沿就是A出栈后的栈顶）而且是该柱子的右边，所以要+1.

                max_area = max(max_area, h*w)      #求最大面积
            stack.append(i)                    #高于栈顶元素，则进栈
        return max_area


#解法2 分治
# 先找最矮的柱子， 然后矩形的宽向两边延伸
# 寻找最矮的柱子左边最大面积的矩形
# 寻找最矮柱子右边最大面积的矩形

#代码问题 同样一个测试样例，用本地的ide可以计算出正确的结果，但是leetcode 计算出的是错误的，后续修改了代码，end少了加一。
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        
        return self.CA(heights,0,len(heights)-1)  

    def CA(self,heights,start,end):
        if start > end:
            return 0               

        min_index = start                                
        for i in range(start,end+1):               #加一操作，这里做错了
            if heights[min_index] > heights[i]:         #只存最矮的柱子的索引
                min_index = i
        max1 = heights[min_index] *(end - start + 1)    #找到最矮的柱子，算它的面积
        max2 = self.CA(heights,start,min_index - 1)     #左边最矮的柱子的最大面积
        max3 = self.CA(heights,min_index + 1, end)      #右边最矮的柱子的最大面积
        max2_3 = max(max2,max3)                       
        return max(max1,max2_3)
        
        
