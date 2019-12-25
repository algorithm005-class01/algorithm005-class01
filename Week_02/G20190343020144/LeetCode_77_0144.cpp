/**
 * 
 * 
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

/*
 *  回溯解决 , 注意这里的组合, 后面的元素要比前面的元素大才可以!!!
 *  和46 47 题差不多, 难度更简单一些
**/
class Solution
{
public:
    vector<vector<int>> combine(int n, int k)
    {
        if (n < k)
            return {};
        vector<vector<int>> ans;
        vector<int> path;
        _combine(n, k, 0, path, ans);
        return ans;
    }

    void _combine(int n, int k, int lasted, vector<int> &path, vector<vector<int>> &ans)
    {
        if (path.size() == k)
        {
            // vector<int> n_path = {begin(path), end(path)};
            // 内存消耗减小了一点
            ans.push_back(path);
            return;
        }
        // 剪枝, 保证后面选择列表加上已选的个数 是大于 目标 k 的, 否则跳过  ------ 这一个剪枝快了近一倍 -----
        if ((k - path.size()) > (n - lasted))
            return;
        // 选择列表 , 因为后面的元素比前面的要大, 故抛弃(已选最大值 + 1)前面的即可
        for (size_t i = (lasted + 1); i <= n; i++)
        {
            path.push_back(i);
            _combine(n, k, i, path, ans);
            path.pop_back();
        }
    }
};

void printArr(vector<int> &nums)
{
    for (size_t i = 0; i < nums.size(); i++)
    {
        cout << nums[i] << ",";
    }
    cout << endl;
};

int main()
{
    vector<vector<int>> ans = Solution().combine(4, 2);
    for (size_t i = 0; i < ans.size(); i++)
    {
        printArr(ans[i]);
    }
    return -1;
}