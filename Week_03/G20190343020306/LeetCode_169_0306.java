/*
LeetCode 169, 求众数
思路: 通过分治法求解
先求左边一半元素的众数、再求右边一般元素的众数
如果左右两边众数一样, 则返回这个众数
如果不一样, 还需要统计左右两边的众数在目前的统计区间里面出现的最大次数, 返回出现最多的那个

不过最NB的还是那个投票计数法
一次消掉众数以及同样个数的非众数, 只需要O(n)的复杂度
*/
class Solution {
    public int majorityElement(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        return solve(nums, begin, end);
    }

    private int solve(int[] nums, int begin, int end) {
        if (begin >= end - 1) {
            return nums[begin];
        }
        int leftMajority = solve(nums, begin, (begin + end) / 2);
        int rightMajority = solve(nums, (begin + end) / 2 + 1, end);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftOccurances = countOccurances(leftMajority, nums, begin, end);
        int rightOccurances = countOccurances(rightMajority, nums, begin, end);

        return leftOccurances > rightOccurances ? leftMajority: rightMajority;

    }

    private int countOccurances(int majorityCandidate, int[] nums, int begin, int end) {
        int count = 0;
        for (int i = begin; i <= end; i++) {
            if (nums[i] == majorityCandidate) {
                count++;
            }
        }
        return count;
    }
}