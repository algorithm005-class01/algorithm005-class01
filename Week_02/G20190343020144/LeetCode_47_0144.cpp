/**
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

/**
 * [1,1,2]
 * 
 * 
*/
class WrongSolution
{
public:
    vector<vector<int>> permuteUnique(vector<int> &nums)
    {
        if (nums.size() < 2)
            return {nums};
        // 子数组
        vector<vector<int>> ans;
        vector<int> path;
        sort(nums.begin(), nums.end());
        _permute(nums.size(), nums, ans, 0);
        return ans;
    }

    /**
   * 递归调用子元素
   * @param length 原始数组总长度
   * @param choosen 选择的索引
  */
    void _permute(int length, vector<int> &choices, vector<vector<int>> &ans, int choosen)
    {
        if (choosen == length)
        {
            vector<int> path = {begin(choices), end(choices)};
            ans.push_back(path);
            return;
        }

        for (int i = choosen; i < length; i++)
        {
            // 去重 , 注意这里  i != choosen, 也就是说 位置不想等的两个数 如果相等 就不需要再次替换了
            // 仅仅上面的判断时不可以的
            if (i != choosen && choices[i] == choices[choosen])
            {
                continue;
            }
            // 新的路径
            swap(choices[i], choices[choosen]);
            // 新的选择
            _permute(length, choices, ans, choosen + 1);
            // 取消
            swap(choices[i], choices[choosen]);
        }
    }
};

class Solution
{
public:
    vector<vector<int>> permuteUnique(vector<int> &nums)
    {
        if (nums.size() < 2)
            return {nums};
        // 子数组
        vector<vector<int>> ans;
        vector<int> path;
        vector<bool> used(nums.size(), false);
        sort(nums.begin(), nums.end());
        _permute(nums, path, ans, 0, used);
        return ans;
    }

    /**
   * 递归调用子元素
   * @param length 原始数组总长度
   * @param choosen 选择的索引
  */
    void _permute(vector<int> &nums, vector<int> &choices, vector<vector<int>> &ans, int choosen, vector<bool> &used)
    {
        if (choosen == nums.size())
        {
            vector<int> path = {begin(choices), end(choices)};
            ans.push_back(path);
            return;
        }

        for (int i = 0; i < nums.size(); i++)
        {
            // 选过的就跳过, 仅仅关注没有被选中的元素, 把未选中的元素添加到路径中
            if (used[i])
            {
                continue;
            }

            // 去重 , 位置不相等的两个数 如果相等 就不需要再次替换了
            // 仅仅上面的判断时不可以的, 而且还需要判断是否已经使用过了
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
            {
                continue;
            }
            // 新的路径
            used[i] = true;
            // choices.push_back(nums[i]);
            // 新的选择
            _permute(nums, choices, ans, choosen + 1, used);
            // 取消
            used[i] = false;
            choices.pop_back();
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
    vector<int> nums = {1, 1, 2, 2};
    vector<vector<int>> ans = Solution().permuteUnique(nums);
    for (size_t i = 0; i < ans.size(); i++)
    {
        printArr(ans[i]);
    }
    return -1;
}