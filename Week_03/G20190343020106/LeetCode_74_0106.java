package week03;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int x = matrix[mid / n][mid % n];
            if (target == x)
                return true;
            else if (target < x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}