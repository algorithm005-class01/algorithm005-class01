package main.leetcode_solutions.search;

/**
 * @author wenzhuang
 * @date 2019/12/29 9:15 PM
 */
public class T74_SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low  <= high){
            int mid = low + ((high - low) >> 1);
            int i = mid / n, j = mid % n;
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return false;
    }
}
