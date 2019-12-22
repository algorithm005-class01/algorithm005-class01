/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

/**
 * 回溯算法 + 剪枝
 * 
*/
class Solution
{
public:
  vector<vector<int>> permute(vector<int> &nums)
  {
    if (nums.size() < 2)
      return {nums};
    // 子数组
    vector<vector<int>> ans;
    vector<int> path;
    _permute(path, nums, ans);
    return ans;
  }

  /**
   * 递归调用子元素
  */
  void _permute(vector<int> path, vector<int> choices, vector<vector<int>> &ans)
  {
    if (choices.size() == 0)
    {
      ans.push_back(path);
      return;
    }

    for (int i = 0; i < choices.size(); i++)
    {
      // 新的路径
      vector<int> n_path = {begin(path), end(path)};
      n_path.push_back(choices[i]);

      // 新的选择
      vector<int> n_choices = {begin(choices), end(choices)};
      n_choices.erase(n_choices.begin() + i);
      // 递归
      _permute(n_path, n_choices, ans);

      // 这里原来的路径还在, 不需要取消选择
      // path.pop_back();
      // 取消
    }
  }
};

class Solution2
{
public:
  vector<vector<int>> permute(vector<int> &nums)
  {
    if (nums.size() < 2)
      return {nums};
    // 子数组
    vector<vector<int>> ans;
    vector<int> path;
    _permute(nums.size(), nums, ans, 0);
    return ans;
  }

  /**
   * 递归调用子元素
   * @param length 原始数组总长度
   * @param choosen 选择的索引
  */
  void _permute(int length, vector<int> choices, vector<vector<int>> &ans, int choosen)
  {
    if (choosen == length)
    {
      vector<int> path = {begin(choices), end(choices)};
      ans.push_back(path);
      return;
    }

    for (int i = choosen; i < length; i++)
    {
      // 新的路径
      swap(choices[i], choices[choosen]);
      // 新的选择
      _permute(length, choices, ans, choosen + 1);
      // 取消
      swap(choices[i], choices[choosen]);
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

/**
 * 这里有一个关于回溯特别好的文章 https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
 * 
 * 摘抄 回溯模板

result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择

关键点:
1、路径：也就是已经做出的选择。

2、选择列表：也就是你当前可以做的选择。

3、结束条件：也就是到达决策树底层，无法再做选择的条件。

 * 
*/
int main()
{
  vector<int> nums = {1, 2, 3};
  vector<vector<int>> ans = Solution2().permute(nums);
  for (size_t i = 0; i < ans.size(); i++)
  {
    printArr(ans[i]);
  }

  return -1;
}