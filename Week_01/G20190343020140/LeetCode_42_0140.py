#解法1数学法
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #数学：平铺面积算法: 以最高高度的墙高  为高度,高 h = max(height)，宽 w = len(height),面积 s = h * w
        #从左到右遍历 找左边最高的墙，从右到做遍历，找右边最高的墙，算面积1， 面积1多算了最高高度的面积，所以减掉最高高度的面积， s1 = s1 - h * w
        #剩下的面积就是墙的面积和水的面积，减去抢的面积就是水的面积，遍历  s -= h[i] 
        if not height or len(height) < 3:
            return 0

        area, left_max, right_max = 0, 0, 0
        for i in range(len(height)):
            left_max = max(left_max,height[i])  #更新左边最高的墙
            right_max = max(right_max,height[-i-1]) #更新右边最高的墙  从右到左，顺序倒过来

            area += left_max + right_max -height[i]  #宽是1，需要乘1，乘1后，对原式不变，area = 平铺面积-墙的面积       
        return area - len(height) * left_max   #遍历完后，left_max = right_max，选择其一就行，area 再减去多变的最高高度的面积 area = area - h * w  高 h = max(height)，宽 w = len(height)


#解法2 栈
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #栈
        if not height or len(height) < 3:      
            return 0

        volume,current, n, stack = 0, 0, len(height), []  #初始化,分别是存水量，当前指针，数组长度，栈
        while current < n:
            while stack and height[current] > height[stack[-1]]: #栈不为空，且当前值大于栈顶的值，计算存水量
                h = height[stack[-1]]  #h 为栈顶元素，当前值的第前一个或是第前几个值
                stack.pop()                  #出栈，栈顶元素出栈
                if not stack:   #出栈后栈空了，无操作，直接让当前元素入栈
                    break      
                else:
                     left_index = stack[-1]           
                distance = current - left_index -1  #两个索引号的距离，如 3-1-1
                min1 = min(height[left_index],height[current])  #取较矮的墙
                volume += distance * (min1-h)       #存水量 = 两者距离 * （较矮的墙高-原栈顶的高）
            
            stack.append(current)
            current += 1
        return volume

#解法3 动态规划
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #动态规划
        if not height or len(height) < 3:      
            return 0
        n = len(height)
        left = [0 for i in range(n)]    #存左边最大值
        right = [0 for i in range(n)]    #存右边最大值
        left[0],right[-1] = height[0], height[-1] #初始化，很重要，遍历是从左边的第一个，和右边的倒数第二个开始的，所以左边第0个和右边的倒数一个 都是初始的0值
        
        for i in range(1,n):                    #默认 左边值从第一个开始计算
            left[i] = max(left[i-1],height[i])  #存更新后 左边最大值

        for i in range(n-2,-1,-1):              #默认 左边值从倒数第二个开始计算，递减
            right[i] = max(right[i+1],height[i]) #存更新后 右边最大值

        volume = 0

        for i in range(n):
            colleted_water= min(left[i],right[i]) - height[i] #取左右两边最矮的墙，减去当前墙高，就是能存的水量
            volume += colleted_water    
        return volume

#解法4 双指针

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height or len(height) < 3:  
            return 0
    
        left,right = 0,len(height) -1, #设置左指针和右指针
        l_max,r_max = height[left], height[right] #记录左右两边最高的 高度
        volume = 0 #存水
        while left < right:
            l_max, r_max = max(l_max, height[left]),max(r_max,height[right])
            if l_max <= r_max:
                
                volume += l_max - height[left]
                left += 1
            else:
                
                volume += r_max - height[right]
                right -= 1
        return volume
