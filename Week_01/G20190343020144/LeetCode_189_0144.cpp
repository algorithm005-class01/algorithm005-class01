// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

// 示例 1:

// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4]
// 解释:
// 向右旋转 1 步: [7,1,2,3,4,5,6]
// 向右旋转 2 步: [6,7,1,2,3,4,5]
// 向右旋转 3 步: [5,6,7,1,2,3,4]
// 示例 2:

// 输入: [-1,-100,3,99] 和 k = 2
// 输出: [3,99,-1,-100]
// 解释:
// 向右旋转 1 步: [99,-1,-100,3]
// 向右旋转 2 步: [3,99,-1,-100]
// 说明:

// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/rotate-array
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#include <vector>
#include <iostream>
using namespace std;

void printArr(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << ",";
    }
    cout << endl;
}

/**
 * 方案一: 一步一步来呗, 处理被覆盖数据比较简单
 * 超时
*/
class Solution
{
public:
    void rotate(vector<int> &nums, int k)
    {
        cout << "------ before ------" << endl;
        printArr(nums);
        cout << "------ before ------" << endl;

        if (nums.size() <= 1)
            return;
        k = k % nums.size();
        if (k == 0)
            return;
        int i = 0;
        int temp = 0;
        while (k)
        {
            i = nums.size() - 2;
            temp = nums[nums.size() - 1];
            while (i >= 0)
            {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[0] = temp;
            k--;
        }
        cout << "------ after ------" << endl;
        printArr(nums);
        cout << "------ after ------" << endl;
    }
};

/**
 * 方案二: 一步迁移前完成, 重点是 如何处理被覆盖数据问题 (因为仅仅按照方案一会发现有多个被覆盖的数据,为了只有一个被覆盖数据,那么迁移数据的步骤将不同与方案一了)
 * 
*/
class Solution2
{
public:
    void rotate(vector<int> &nums, int k)
    {
        cout << "------ before ------" << endl;
        printArr(nums);
        cout << "------ before ------" << endl;

        if (nums.size() <= 1)
            return;
        k = k % nums.size();
        if (k == 0)
            return;

        // 不论哪种情况 都必须要挪动 n 次
        int count = 0;
        for (int start = 0; count < nums.size(); start++)
        {
            // 当前要移动k的元素索引
            int current = start;
            // 后面会一直更新这个值, 移动后被覆盖的值
            int prev = nums[start];
            do
            {
                // current索引 移动k后的位置
                int next = (current + k) % nums.size();
                // 先将被覆盖的值保存起来, 真正覆盖后,更新到pre
                int temp = nums[next];
                // 覆盖
                nums[next] = prev;
                // 更新到pre
                prev = temp;
                // 更新下一个要移动k步的索引值
                current = next;
                // 累计已经移动的元素数
                count++;
            } while (start != current); // 当 k % nums.size() == 0 时会出现环的问题
        }

        cout << "------ after ------" << endl;
        printArr(nums);
        cout << "------ after ------" << endl;
    }
};

/**
 * 
 * 方案三: 多次旋转数组 
 *  // 1, 2, 3, 4, 5, 6
    // 6, 5 ,4, 3, 2, 1
    // 6, 5 // 4, 3, 2, 1
    // 5, 6, 1, 2, 3, 4
*/
class Solution3
{
public:
    void rotate(vector<int> &nums, int k)
    {
        cout << "------ before ------" << endl;
        printArr(nums);
        cout << "------ before ------" << endl;

        if (nums.size() <= 1)
            return;
        k = k % nums.size();
        if (k == 0)
            return;
        // 整体反转一次
        rotate(nums, 0, nums.size() - 1);
        // 找到中心点
        int middle = k - 1;
        // 中心点左侧反转一次
        rotate(nums, 0, middle);
        // 中心点右侧反转一次
        rotate(nums, middle + 1, nums.size() - 1);

        cout << "------ after ------" << endl;
        printArr(nums);
        cout << "------ after ------" << endl;
    };

    void rotate(vector<int> &nums, int lo, int hi)
    {
        while (lo < hi)
        {
            swap(nums[lo++], nums[hi--]);
        }
    }
};

int main(int argc, char **argv)
{
    vector<vector<int>> arrs;
    arrs.push_back({1, 4, 6, 3, 7, 3, 7, 3, 6});
    arrs.push_back({1, 4, 6, 8, 7, 3, 7, 3, 6});
    arrs.push_back({1, 4, 6});
    arrs.push_back({9, 4, 6, 3, 7, 7, 3, 6});
    arrs.push_back({1, 4});
    arrs.push_back({4, 1, 4});
    arrs.push_back({1, 2, 3, 4, 5, 6});

    for (auto arr : arrs)
    {
        Solution3().rotate(arr, 2);
    }
    return -1;
}

//  * 方案一: 最开始就是老实一步一步的迁移数据, 但是会超时
//  * 方案二: 是方案一的升级版, 一次迁移完成, 但是忽略了 有种情况,只能迁移一半的数据,  注意这里即可, 参考 leetcode 写了一遍, count 用法太经典了
//  * 方案三: 类似旋转数组的问题 经常会有 多次旋转不同区间数组来解决, 虽然我并没有想到