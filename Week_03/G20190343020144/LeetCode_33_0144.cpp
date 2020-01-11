/**
 * 
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

#include <iostream>
#include <vector>
using namespace std;

/**
 * 1. 二分法 , 同理可以找到中转点
 * 
*/
class Solution {
public:
        // 关键是查找 单调性, 明确单调性 2 -> 3 和 2 -> 2 -> 3 都有单调性 
        // 单调性①
        // 中间
        // case 5. [4,5,6,7,0,1,2] target 7

        // 左侧
        // case 2. [4,5,6,7,0,1,2] target 4
        // case 3. [4,5,6,7,0,1,2] target 5

        // 右侧
        // case 4. [4,5,6,7,0,1,2] target 1
        // case 1. [4,5,6,7,0,1,2] target 2

        // 单调性②
        // case 1. [6,7,0,1,2,4,5]  mid = 1; target 1

        // case 1. [6,7,0,1,2,4,5]  mid = 1; target 6
        // case 1. [6,7,0,1,2,4,5]  mid = 1; target 7

        // case 1. [6,7,0,1,2,4,5]  mid = 1; target 2
        // case 1. [6,7,0,1,2,4,5]  mid = 1; target 5


        // 单调性③ , 这里有个错误处理, 其实 mid == nusm[lo] 也是单调的
        // cas  [3,1] target = 1; mid = 3

        // 二分法查找
        
    int search(vector<int>& nums, int target) {
         int lo = 0, hi = nums.size() - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (hi - lo) / 2  + lo;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[lo]) { // 仅仅更改  nums[mid] >= nums[lo] 就解决了 nums[mid] > nums[lo] 的 [3,1] target = 1 的情况
                // 左侧单调
                if (target < nums[mid] && target >= nums[lo] ) {
                    hi = mid - 1;
                } else  {
                    lo = mid + 1;
                }
            } else {
                // 右侧单调
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
};



int main () 
{
    vector<int> nums = {4,5,6,7,0,1,2};
    int ret =  Solution().search(nums,0);
    cout << ret << endl;
    return -1;
}