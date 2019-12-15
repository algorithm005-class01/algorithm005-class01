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

