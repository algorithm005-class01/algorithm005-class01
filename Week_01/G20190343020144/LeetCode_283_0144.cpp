// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

// 示例:

// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]
// 说明:

// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/move-zeroes
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#include <iostream>
#include <vector>

using namespace std;

/*
双指针处理
慢指针永远是指向 非零的下标
快指针指向当前需要判断是否非零挪动元素的下标
[0,0,0,0,0,1] 该数组的操作次数为 n - 1, 需要优化  见 Solution2
*/
class Solution
{
public:
    void moveZeroes(vector<int> &nums)
    {
        if (nums.size() <= 1)
            return;
        // 注意声明变量的初值问题
        int numIndex = 0, i = 0;
        while (i < nums.size())
        {
            if (nums[i] != 0)
            {
                nums[numIndex] = nums[i];
                numIndex++;
            }
            i++;
        }
        while (numIndex < nums.size())
        {
            nums[numIndex++] = 0;
        }
    }
};

class Solution2
{
public:
    void moveZeroes(vector<int> &nums)
    {
        if (nums.size() <= 1)
            return;
        // 注意声明变量的初值问题
        int numIndex = 0, i = 0;
        while (i < nums.size())
        {
            if (nums[i] != 0) // 仅仅非零的时候才需要交换, 这么做的原因是 快指针与慢指针中间都是间隔的 0
            {
                swap(nums[numIndex], nums[i]);
                numIndex++;
            }
            i++;
        }
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
    arrs.push_back({0, 4, 0, 3, 7, 3, 7, 3, 6});
    arrs.push_back({1, 4, 6, 8, 7, 3, 7, 3, 6});
    arrs.push_back({0, 1, 0, 3, 12});
    arrs.push_back({0, 0, 0, 3, 7, 7, 3, 6});
    arrs.push_back({1, 4, 0, 0, 0, 3});
    arrs.push_back({40, 0, 4, 3, 4, 0, 4});
    arrs.push_back({0, 1, 2, 3, 4, 5, 6, 0});

    for (auto arr : arrs)
    {
        printArr(arr);
        Solution2().moveZeroes(arr);
        printArr(arr);
    }
    return -1;
}
