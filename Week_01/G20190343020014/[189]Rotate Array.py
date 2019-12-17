#给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
#
# 示例 1: 
#
# 输入: [1,2,3,4,5,6,7] 和 k = 3
#输出: [5,6,7,1,2,3,4]
#解释:
#向右旋转 1 步: [7,1,2,3,4,5,6]
#向右旋转 2 步: [6,7,1,2,3,4,5]
#向右旋转 3 步: [5,6,7,1,2,3,4]
# 
#
# 示例 2: 
#
# 输入: [-1,-100,3,99] 和 k = 2
#输出: [3,99,-1,-100]
#解释: 
#向右旋转 1 步: [99,-1,-100,3]
#向右旋转 2 步: [3,99,-1,-100] 
#
# 说明: 
#
# 
# 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
# 要求使用空间复杂度为 O(1) 的 原地 算法。 
# 
# Related Topics 数组



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        m, n = 0, len(nums)  # m 表示已经旋转的位置
        if n <= 1:
            return

        # 翻转数组了就
        if k >= n:
            pass

        # 待旋转数据
        for i in range(n - k, n):
            temp = nums[i]  # 把位置空出来， 5,6,7
            # 挪动数据
            j = i - 1
            while j >= m:
                nums[j + 1] = nums[j]
                j -= 1
            # 插入数据
            nums[m] = temp
            m += 1
        print(nums)

#leetcode submit region end(Prohibit modification and deletion)

# Solution().rotate([1,2,3,4,5,6,7], 3)
Solution().rotate([1,2, 3], 3)