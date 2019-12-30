/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 此题运用的是二分查找的思路，主要重点在于将有序的二维数组转换为一维的有序数据，
         * 这样就能很方便的使用二分查找获取目标值
         * 关键点：一维坐标与二维坐标的转换
         * 注意的问题：边界条件要注意，没有用等于的时候，得到的是错误的答案
         */
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = matrix[mid / n][mid % n];
            if (midVal == target) {
                return true;
            }
            if (midVal > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}