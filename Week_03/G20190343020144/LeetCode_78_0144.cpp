/**
 * 
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

推荐题解: https://leetcode-cn.com/problems/subsets/solution/liang-chong-fang-fa-qiu-jie-zi-ji-by-tangzixia/
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

class SolutionBacktrace
{
public:
    // 回溯算法
    vector<vector<int>> subsets(vector<int> &nums)
    {
        // 边界条件, 注意这里和 子集的概念要明确
        if (nums.size() == 0)
            return {{}};

        vector<int> path;
        vector<vector<int>> ans;
        backtrace(nums, 0, path, ans);
        return ans;
    }

    void backtrace(vector<int> &nums, int rightpoint, vector<int> &path, vector<vector<int>> &ans)
    {
        // terminator 注意这里并不需要判断 path.size() <= nums.size() , 因为 后面的for循环决定 path的size一定不会超过 nums.size()
        // if (path.size() <= nums.size())
        // {
        ans.push_back(path);
        // }
        // process
        for (int i = rightpoint; i < nums.size(); i++)
        {
            // 注意 这里遍历已经包含不取的情况
            // 取值
            path.push_back(nums[i]);
            // 回溯
            backtrace(nums, i + 1, path, ans);
            // reset, 这里backtrace中的path 如果是传递引用, 则不用复原, 因为是局部参数
            path.pop_back();
        }
    }
};

class SolutionLevel
{
public:
    //层级遍历
    vector<vector<int>> subsets(vector<int> &nums)
    {
        // 边界条件, 注意这里和 子集的概念要明确
        if (nums.size() == 0)
            return {{}};
        vector<int> path;
        vector<vector<int>> ans;
        ans.push_back({});

        for (int i = 0; i < nums.size(); i++)
        {
            // 内存遍历的时候,  复制一份新的数组
            vector<vector<int>> n_ans = ans;
            for (int j = 0; j < n_ans.size(); j++)
            {
                n_ans[j].push_back(nums[i]);
                ans.push_back(n_ans[j]);
            }
        }

        return ans;
    }
};

/*
*  集合中的元素 , 选与不选 构成了 一个满二叉树 的 状态决策树 
* 那么只需要将树进行遍历即可, 前中后序遍历都可以
*/
class LeetCode_78_0144
{
public:
    void helper(vector<vector<int>> &res, vector<int> tmp, vector<int> &nums, int level)
    {
        if (level >= nums.size())
        {
            res.push_back(tmp);
            return;
        }
        // 根
        tmp.push_back(nums[level]);
        // 左
        helper(res, tmp, nums, level + 1);
        // 右
        tmp.pop_back();
        helper(res, tmp, nums, level + 1);
    }

    vector<vector<int>> subsets(vector<int> &nums)
    {
        vector<vector<int>> res;
        vector<int> tmp;
        helper(res, tmp, nums, 0);
        return res;
    }
};

// 分治法

// 动态规划法 https://leetcode-cn.com/problems/subsets/solution/fen-zhi-fa-ji-qi-die-dai-xun-huan-shi-xian-he-di-g/