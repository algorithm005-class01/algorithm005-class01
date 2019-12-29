/**
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

/**
 * 
 * 贪心算法
*/
class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int maxS = nums[0], cur = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            cur = max(nums[i], nums[i] + cur);
            maxS = max(maxS, cur);
        }
        return maxS;
    }
};

class Solution DivideConquer
{
public:
    int maxSubArray(vector<int> &nums)
    {
        return _helper(nums, 0, nums.size() - 1);
    }

    int _combine(vector<int> &nums, int lo, int hi, int middle)
    {
        if (lo == hi)
            return nums[lo];
        // 利用贪心处理 , 包含 middle 在内的, 连续最大子序列和
        int leftMax = nums[middle], curSum = 0;
        // 注意边界 是闭区间
        for (int i = middle; i >= lo; i--)
        {
            // 连续和, 这个计算和上面的贪心算法不一样, 贪心是求连续和的最大值
            curSum += nums[i];
            leftMax = max(leftMax, curSum);
        }

        // 右侧 包含middle+1的 连续最大子序列和
        int rightMax = nums[middle + 1];
        curSum = 0;
        // 注意边界 是闭区间
        for (int i = middle + 1; i <= hi; i++)
        {
            // 连续和, 这个计算和上面的贪心算法不一样, 贪心是求连续和的最大值
            curSum += nums[i];
            rightMax = max(rightMax, curSum);
        }
        // 合并 两边的最大和
        return leftMax + rightMax;
    }

    int _helper(vector<int> &nums, int lo, int hi)
    {
        if (lo == hi)
            return nums[lo];
        int middle = lo + (hi - lo) / 2;
        /// 分治法的理解是 其最大子序列和, 要么是左侧的, 要么是右侧的, 要么是穿过中间的

        // 左侧的  不包含_combine的复杂度是 O(logn)
        int left = _helper(nums, lo, middle);
        // 右侧的  不包含_combine的复杂度是 O(logn)
        int right = _helper(nums, middle + 1, hi);
        // 穿过中间 也就是包含中间值的最大子序列, 最大子序列连续和的计算元素一定包含中间值 , 复杂度O(n)
        int m = _combine(nums, lo, hi, middle);
        // 最后取最大值即可, 将整体连贯起来 , 整体的复杂度是 O(logn) * O(n) ==> O(nlogn)
        return max(max(left, right), m);
    }
};

// 动态规划 , dp[i] = max(dp[i - 1], nums[i] + dp[i - 1]); 和贪心一样的
class SolutionDP
{
public:
    int maxSubArray(vector<int> &nums)
    {
        vector<int> dp(nums.size(), 0);
        // 初始的最大连续子序列和
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.size(); i++)
        {
            // 错误算法 dp[i] = max(dp[i - 1], nums[i] + dp[i - 1]);
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};