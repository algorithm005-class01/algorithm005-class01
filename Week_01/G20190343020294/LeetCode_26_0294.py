#给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
#
# 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
#
# 示例 1:
#
# 给定数组 nums = [1,1,2],
#
#函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
#
#你不需要考虑数组中超出新长度后面的元素。
#
# 示例 2:
#
# 给定 nums = [0,0,1,1,1,2,2,3,3,4],
#
#函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
#
#你不需要考虑数组中超出新长度后面的元素。
#
#
# 说明:
#
# 为什么返回数值是整数，但输出的答案是数组呢?
#
# 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
#
# 你可以想象内部操作如下:
#
# // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
#int len = removeDuplicates(nums);
#
#// 在函数里修改输入数组对于调用者是可见的。
#// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
#for (int i = 0; i < len; i++) {
#    print(nums[i]);
#}
#
# Related Topics 数组 双指针



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # 1. 遍历每个元素， 如果之前出现过则删除掉 O(n^2)
        # deleted = []
        # for i in range(1, len(nums)):
        #     for j in range(i):
        #         if nums[i] == nums[j]:
        #             deleted.append(nums[i])
        #             break

        # for i in deleted:
        #     nums.remove(i)
        # return len(nums)

        # 2. 排序，遍历每个元素， 如果nums[i] == nums[i-1]， 删除 O(n)
        # deleted = []
        # for i in range(1, len(nums)):
        #     if nums[i] == nums[i-1]:
        #         deleted.append(nums[i])

        # for i in deleted:
        #     nums.remove(i)
        # return len(nums)
        # 这种解法找出重复的元素最后删除，多了一次遍历（每次删除），其实是增加n^2的复杂度
        #
        # #####################################

        # 双指针法
        # 使i指向去重完后的第一个位置， j遍历后面的每一个元素（找出第二位置的元素），如果nums[i]!=nums[j],则i++,把第j个元素放到i位置
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]

        return i + 1
