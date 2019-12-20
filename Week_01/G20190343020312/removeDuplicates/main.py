from solution import Solution
nums = [0,0,1,1,1,2,2,3,3,4]
s = Solution()
count = s.removeDuplicates(nums)
list1 = []
for i in range(count):
    list1.append(nums[i])
print(list1)
