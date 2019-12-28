package Week_03.G20190343020220.leetcode_153_0220;


/*
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
*/

/**
 * @author Darcy
 * @date 2019-12-28 16:23
 */
public class Sulotion {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int lo = 0;
        int hi = nums.length - 1;
        int start = nums[0];
        if (start < nums[hi]) {
            return start;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    /*查找最大值和最新值的位置*/
    public int[] find(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int lo = 0;
        int hi = nums.length - 1;
        int start = nums[0];
        if (start < nums[hi]) {
            return new int[]{-1};
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return new int[]{lo - 1, lo};
    }

    public static void main(String[] args) {
        int[] ints = new Sulotion().find(new int[]{4, 0, 1, 2, 3});
        System.out.println("ints = " + ints.toString());
    }
}
