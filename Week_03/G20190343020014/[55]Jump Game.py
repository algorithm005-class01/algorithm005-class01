# 给定一个非负整数数组，你最初位于数组的第一个位置。
#
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
#
# 判断你是否能够到达最后一个位置。 
#
# 示例 1: 
#
# 输入: [2,3,1,1,4]
# 输出: true
# 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
# 
#
# 示例 2: 
#
# 输入: [3,2,1,0,4]
# 输出: false
# 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
# 
# Related Topics 贪心算法 数组


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    # 笨回溯-超时
    def canJump1(self, nums):
        def backtrack(path):
            if flag:
                return
            # 满足条件添加结果
            if path[-1] == len(nums) - 1:
                flag.append(1)
                return
            current = path[-1]
            if nums[current] == 0:
                return
            for i in range(1, nums[current] + 1):
                # 选择
                path.append(current + i)
                backtrack(path)
                path.pop()

        if not nums: return False
        flag = []
        backtrack([0])
        print(flag)
        return len(flag) > 0

    # 另外回溯写法
    def canJump2(self, nums):
        def backtrack(position):
            # 满足条件添加结果
            if position == len(nums) - 1:
                return True
            steps = min(position + nums[position], len(nums) - 1)
            next_position = position + 1
            while next_position <= steps:
                if backtrack(next_position):
                    return True
                next_position += 1
            return False
        mem = [''] * len(nums)
        rs = backtrack(0)
        print(rs)
        return rs

        # 另外回溯写法  + 记忆化
    def canJump(self, nums):
        def backtrack(position):
            # 满足条件添加结果
            if mem[position] != '':
                return True if mem[position] == 'G' else False

            steps = min(position + nums[position], len(nums) - 1)
            next_position = position + 1
            while next_position <= steps:
                if backtrack(next_position):
                    mem[position] = 'G'
                    return True
                next_position += 1

            mem[position] = 'B'
            return False

        mem = [''] * len(nums)
        rs = backtrack(0)
        print(rs)
        return rs

    # 贪心解法
    def canJump(self, nums):
        max_i = 0  # 初始化当前能到达最远的位置
        for i, jump in enumerate(nums):  # i为当前位置，jump是当前位置的跳数
            if max_i >= i and i + jump > max_i:  # 如果当前位置能到达，并且当前位置+跳数>最远位置
                max_i = i + jump  # 更新最远能到达位置
        print(max_i >= i)
        return max_i >= i


# leetcode submit region end(Prohibit modification and deletion)

Solution().canJump([2, 3, 1, 1, 4])
Solution().canJump([3, 2, 1, 0, 4])
Solution().canJump([0, 1])
Solution().canJump(
    [2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0,
     3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7,
     1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6])
