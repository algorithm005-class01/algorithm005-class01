"""
知识点：list.index(x [, start [, end]])
x: 查找的列表中的对象
start： 查找的起始位置， 选配
end： 查找的结束位置， 选配

list1 = ['Google', 'Runoob', 'Taobao', 'Facebook', 'QQ', 'baidu', 'yunxi']
# 从指定位置开始搜索
print('Taobao 索引值为', list1.index('Taobao'))
# Taobao 索引值为 2
print ('QQ 索引值为', list1.index('QQ', 3, 6))
# QQ 索引值为 4
print ('Runoob 索引值为', list1.index('Runoob', 3, 6))
# ValueError: 'Runoob' is not in list
"""
'''
知识点：逻辑判断
j = None

if j is not None:
    print(' j = True 输出')

if not j:
    print(' j = None 时输出')
    
###
 j = None 时输出
'''

"""
diction = {'a': 1, 'b': 2, 'c': 3}
print(diction.get('c'))
print(diction.get('d'))
##
    3
    None
"""
def towSum1(nums, target):
    """
    解题的思路：expected_num = target - nums[i] 是不是也在列表中且不是 nums[i] 本身
    直接元素遍历 然后条件判断
    时间复杂度 O(nlgn)
    """
    j = None
    lens = len(nums)
    for i in range(lens):
        expected_num = target - nums[i]
        if expected_num in nums:
            # 如果 expected_num 是 nums[i]本身的话就跳过
            if (nums.count(expected_num) == 1) & (expected_num == nums[i]):
                continue
            else:
                j = nums.index(expected_num, i+1)
                break
    if j is not None:
        return [i, j]
    else:
        return []


def twoSum2(nums, target):
    """
    使用字典这种数据结构，类似哈希映射 ，和enumerate方法，提升效率

    目标 ：得到 matched index
    思路：在字典中使用 键 expected_num = target - nums[i]；得到 值 index

    """
    dic = {}
    for index, num in enumerate(nums):
        dic[num] = index
    for i, num in enumerate(nums):
        j = dic.get(target - num, None)  # dict.get(element) 没有键 默认返回None
        if j is not None and i != j:
            return [i, j]
    # 不可以是 and j != i ,这里如果 j = None 的话， 判断 j != i 会出数据类型报错 Nonetype 和 int
    # i != j 保证一个数不会同时被用两次 3 = 6 - 3 ;  nums = [3,2,4] target = 6


# ans = twoSum2([3, 2, 4], 6)
# print(ans)


def twoSum3(nums, target):
    """
    不用全部遍历， 可以提前结束 最坏的情况下 要全部遍历
    这是一个很漂亮的解法
    """
    hashmap = {}
    for i, num in enumerate(nums):
        if hashmap.get(target - num) is not None:
            return [i, hashmap.get(target - num)]
        hashmap[num] = i  # 这句不能放在if语句之前，解决list中有重复值或target-num=num的情况







