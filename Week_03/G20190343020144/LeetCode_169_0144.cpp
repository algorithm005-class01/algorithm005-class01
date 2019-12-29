/**
 * 
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
#include <iostream>
#include <vector>
#include <map>
using namespace std;

/**
1. 双层循环 统计
2. 排序后 n/2 一定是多数
3. 分治求子问题的多数
4. 哈希表
5.  Boyer-Moore 投票算法
*/

class SolutionSort
{
public:
    int majorityElement(vector<int> &nums)
    {
        sort(nums.begin(), nums.end());
        int middle = nums.size() / 2;
        return nums[middle];
    }
};

class SolutionDivideConquer
{
public:
    int majorityElement(vector<int> &nums)
    {
        if (nums.size() == 1)
            return nums[0];
        return majorityElement(nums, 0, nums.size() - 1);
    }

    int majorityElement(vector<int> &nums, int lo, int hi)
    {
        if (lo == hi)
            return nums[lo];
        // 子问题
        int middle = (hi - lo) / 2 + lo;
        int left = majorityElement(nums, lo, middle);
        int right = majorityElement(nums, middle + 1, hi);
        if (left == right)
            return left;
        // 统计次数
        int leftValueCount = countMajorElement(nums, lo, middle, left);
        int rightValueCount = countMajorElement(nums, middle + 1, hi, right);
        return leftValueCount > rightValueCount ? left : right;
    }

    int countMajorElement(vector<int> &nums, int lo, int hi, int value)
    {
        int ret = 0;
        while (lo <= hi)
        {
            if (nums[lo++] == value)
                ret++;
        }
        return ret;
    }
};

/**
 * 类似与 同归于尽的做法, 最后剩下的一定是众数
 * 
*/
class SolutionBoyerMoore
{
public:
    int majorityElement(vector<int> &nums)
    {
        int maj = nums[0];
        int count = 1;
        for (auto num : nums)
        {
            if (count == 0)
            {
                maj = num;
            }
            count += (maj == num ? 1 : -1);
        }
        return maj;
    }
};

class SolutionHash
{
public:
    int majorityElement(vector<int> &nums)
    {
        map<int, int> m;
        for (auto v : nums)
        {
            m[v]++;
        }
        int value = 0;
        for (auto kv : m)
        {
            if (kv.second > nums.size() / 2)
            {
                value = kv.first;
            }
        }
        return value;
    }
}