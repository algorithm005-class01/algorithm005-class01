/***
 * 
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

/**
 * 1. 先把单调性用例写出来
 * 2. 分情况二分
 * 3. 注意边界 判等的情况
 * 4. 注意如何渐进 去除不包含最小值的区间
 * 5. 注意返回的是索引还是值
 * 
*/

class Solution {
public:
    int findMin(vector<int>& nums) {
        int lo = 0, hi = nums.size() - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (hi - lo) / 2  + lo;
            if (nums[mid] >= nums[lo]) { 
                // 仅仅更改  nums[mid] >= nums[lo] 就解决了 nums[mid] > nums[lo] 的 [3,1] target = 1 的情况
                // [3,4,5,1,2]
                // [2,3,4,5,1]
                // [1,2,3,4,5]
                // 左侧单调, 最小值在左侧, 和 hi比较 
                if (nums[lo] > nums[hi]) {
                    lo = mid + 1;                    
                } else {
                    return nums[lo];
                }
            } else {
                 // [5,1,2,3,4]
                 // [4,5,1,2,3]
                // 右侧单调, 去掉右侧
                if (nums[mid] < nums[hi]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return nums[lo];
    }
};