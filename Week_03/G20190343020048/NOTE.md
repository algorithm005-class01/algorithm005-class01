学习笔记

# 分治与回溯
分治与回溯最关键的是要能够找到重复子问题，然后进行递归求解
要学会分治与回溯的代码模板

# 深度优先搜索与广度优先搜索
两种图的搜索方式，一般来说深度优先搜索需要使用递归或者栈来求解，广度优先搜索需要使用队列。
广度优先搜索适合用来寻找最短路径等，深度优先搜索适合用来查找所有的搜索路径。
需要能写出广度优先搜索及深度优先搜索（递归、非递归）的代码模板

# 贪心算法
特定条件下使用贪心算法，能够快速得到最优解或者近似解

# 二分查找
二分查找的前提：
1. 目标函数单调性
2. 存在上限界
3. 能够通过索引访问
需要能够写出二分查找的代码模板

# 第11课课后作业
使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
解答：其实就是查找半有序数组的最小值，如果最小值不在位置0，那最大值一定在最小值的左边一个位置，也就是无序的地方
```java
public int findMin(int[] nums) {
    if (nums.length == 1){
        return nums[0];
    }
    int low = 0, high = nums.length - 1;
    while (low <= high){
        int mid = low + ((high - low) >> 1);
        if ((mid == 0 && nums[mid] < nums[nums.length - 1]) || (mid > 0 && nums[mid] < nums[mid - 1])){
            return nums[mid];
        } else if (nums[mid] > nums[nums.length - 1]){
            low = mid + 1;
        } else{
            high = mid - 1;
        }
    }
    return nums[0];
}
```
