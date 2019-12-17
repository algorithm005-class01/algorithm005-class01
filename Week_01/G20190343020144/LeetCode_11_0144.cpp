/**
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
    [
    [-1, 0, 1],
    [-1, -1, 2]
    ]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/3sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        if (nums.size() < 3)
            return {};
        vector<vector<int>> ans;
        // nlogn
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++)
        {
            int fixed = nums[i];
            if (fixed > 0)
                break;
            // 原因是重复计算了, 剪枝
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 真正计算 i , l  ,r
            int l = i + 1;
            int r = nums.size() - 1;
            while (l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0)
                {
                    r--;
                }
                else if (sum == 0)
                {
                    ans.push_back({nums[i], nums[l], nums[r]});
                    // l r 区间 可能有相等的值, 重复三元组的不能包含
                    while (l < r && (nums[l] == nums[++l]))
                    {
                    }
                    while (l < r && (nums[r] == nums[--r]))
                    {
                    }
                }
                else
                {
                    l++;
                }
            }
        }

        return ans;
    }
};

void printArr(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << ",";
    }
    cout << endl;
}

int main(int argc, char **argv)
{
    vector<vector<int>> arrs;
    arrs.push_back({-1, 0, 1, -3, 3, 2, -1, -4});
    arrs.push_back({-1, 0, 1, 2, -1, -4});
    arrs.push_back({1, 4, 6, 8, -5, -3, -6, -4});
    for (auto arr : arrs)
    {
        printArr(arr);
        cout << "----- caculate begin --- " << endl;
        for (auto inner : Solution().threeSum(arr))
        {
            printArr(inner);
            cout << "----- inner --- " << endl;
        }
        cout << "----- caculate end --- " << endl;
    }
    return -1;
}