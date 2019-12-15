"""189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
"""


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.

        有助于理解的比喻：把数组中的元素比作学生，坐标比作座位。然后开始换座位，第一个同学起身坐到 k+1 座位上，k+1 上的同学被挤走，
        去到他后k个座位上，反复执行；有一种情况，其中有同学被挤出来后做到了第一个位置上（空座位，没人被挤走），那么就要顺着从第二个位置上
        的同学换位置，直到所有同学做到他最终该坐的位置上，n 个同学换 n 次
        """
        length = len(nums)
        k %= length
        start = 0
        count = 0

        while count < length:
            current = start
            prev = nums[start]

            while True:
                next_ = (current + k) % length
                tmp = nums[next_]
                nums[next_] = prev

                current = next_
                prev = tmp

                count += 1

                if start == current:
                    break
            start += 1
