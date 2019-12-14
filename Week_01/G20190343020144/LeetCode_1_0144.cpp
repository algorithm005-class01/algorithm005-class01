// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

// 示例:

// 给定 nums = [2, 7, 11, 15], target = 9

// 因为 nums[0] + nums[1] = 2 + 7 = 9
// 所以返回 [0, 1]

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/two-sum
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#include <unordered_map>
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        unordered_map<int, int> map;
        for (int i = nums.size() - 1; i >= 0; i--)
        {
            map[nums[i]] = i;
        }
        int s = 0, dst = 0;
        unordered_map<int, int>::iterator itr;
        for (int i = 0; i < nums.size(); i++)
        {
            dst = target - nums[i];
            itr = map.find(dst);
            if (itr != map.end())
            {
                s = itr->second;
                if (s != i)
                {
                    return {i, s};
                }
            }
        }
        return {};
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
    arrs.push_back({3, 2, 4});

    for (auto arr : arrs)
    {
        vector<int> v = Solution().twoSum(arr, 6);
        printArr(v);
    }
    return -1;
}