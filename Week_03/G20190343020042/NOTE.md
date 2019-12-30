学习笔记
本周主要内容包括，分治、回溯， 深度优先搜索和广度优先搜索，贪心算法，二分查找

本周需要机械记忆的部分比较多，主要包括搜索，贪心算法和二分查找

分治和回溯需要找到规律，根据规律来找。


溯算法框架。解决一个回溯问题，实际上就是一个决策树的遍历过程。需要思考 3 个问题：

1、路径：也就是已经做出的选择。

2、选择列表：也就是你当前可以做的选择。

3、结束条件：也就是到达决策树底层，无法再做选择的条件。


寻找旋转有序数组中最小值问题，题解。
通过二分查找不断缩小范围，目标值的要求是小于左右相邻的值
三个重新界定左右边界的条件

右边界小于左边界，且mid位置的值小于右边界，说明最小值在旋转后的数组的右半段。
右边界大于左边界，说明范围内数组由小到大排列，直接收敛r=l。
mid位置的值大于右边界，说明最小值在mid值的右边。
class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0, r = nums.size() - 1;
        if(nums.size() == 1)    return nums[0];
        while(l <= r){
            int mid = l + (r - l) / 2;
            if((mid == 0 && nums[mid] < nums[mid + 1]) || (mid == nums.size()-1 && nums[mid] < nums[mid - 1]) || (mid != 0 && mid != nums.size()-1 && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]))   return nums[mid];
            if(nums[r] <nums[l] && nums[mid] < nums[r]) r = mid - 1;
            else if(nums[r] > nums[l])  r = l;
            else if(nums[mid] > nums[r])    l = mid + 1;
        }
        return -1;
    }
};
