// 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

// 说明:

// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
// 示例:

// 输入:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3

// 输出: [1,2,2,3,5,6]

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/merge-sorted-array
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#include <iostream>
#include <vector>

using namespace std;

/**
 * 类似与归并排序, 也就是需要多余的空间去存储排序好的数组
 * 
*/
class Solution
{
public:
    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
    {
        // if (m < n) swap(nums1, nums2);
        vector<int> nums;

        int l1 = 0, l2 = 0;
        while (l1 < m && l2 < n)
        {
            if (nums1[l1] < nums2[l2])
            {
                nums.push_back(nums1[l1++]);
            }
            else
            {
                nums.push_back(nums2[l2++]);
            }
        }
        //
        while (l1 < m)
        {
            nums.push_back(nums1[l1++]);
        }
        while (l2 < n)
        {
            nums.push_back(nums2[l2++]);
        }
        for (int i = m + n - 1; i >= 0; i--)
        {
            nums1[i] = nums[i];
        }
    };
};

// 因为 nums1 无限大, 所以可以把 nums1 当做是 开辟的空间
class Solution2
{
public:
    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
    {
        // if (m < n) swap(nums1, nums2);
        int p = m + n - 1;

        int l1 = m - 1, l2 = n - 1;
        while (l1 >= 0 && l2 >= 0)
        {
            if (nums1[l1] > nums2[l2])
            {
                nums1[p--] = nums1[l1--];
            }
            else
            {
                nums1[p--] = nums2[l2--];
            }
        }
        // 补充剩下的元素
        while (l1 < 0 && l2 >= 0)
        {
            nums1[p--] = nums2[l2--];
        }
        while (l2 < 0 && l1 >= 0)
        {
            nums1[p--] = nums1[l1--];
        }
    };
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
    arrs.push_back({1, 4, 6, 8, 17, 23, 27, 33, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    vector<int> nums2 = {3, 7, 9};

    for (auto arr : arrs)
    {
        printArr(arr);
        Solution2().merge(arr, 9, nums2, 3);
        printArr(arr);
    }
    return -1;
}