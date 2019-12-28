// 官方正解 0ms
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;

    // 二分查找
    int left = 0, right = m * n - 1;
    int pivotIdx, pivotElement;
    while (left <= right) {
      pivotIdx = (left + right) / 2;
      pivotElement = matrix[pivotIdx / n][pivotIdx % n];
      if (target == pivotElement) return true;
      else {
        if (target < pivotElement) right = pivotIdx - 1;
        else left = pivotIdx + 1;
      }
    }
    return false;
  }
}




// 1ms > 35.83%
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//         int loRow = 0, hiRow = matrix.length - 1;
//         int loCol = 0, hiCol = matrix[0].length - 1;
//         while (loRow <= hiRow) {
//             int midRow = (loRow + hiRow) / 2;
//             if (matrix[midRow][loCol] <= target && target <= matrix[midRow][hiCol]) {
//                 while(loCol <= hiCol) {
//                     int midCol = (loCol + hiCol) / 2;
//                     if (target == matrix[midRow][midCol]) return true;
//                     else if (target < matrix[midRow][midCol]) hiCol = midCol - 1;
//                     else loCol = midCol + 1;
//                 }
//                 return false;
//             }
//             else if (target < matrix[midRow][loCol]) hiRow = midRow - 1;
//             else loRow = midRow + 1;
//         }

//         return false;
//     }
// }

// 1ms > 35.83%
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//         int hiRow = matrix.length;
//         int hiCol = matrix[0].length;
//         for ( int i = 0; i < hiRow; i++) {
//             if (matrix[i][hiCol - 1] < target) continue;
//             for (int j = 0; j < hiCol; j++) {
//                 if (matrix[i][j] == target) return true;
//             }
//             return false;
//         }
//         return false;
//     }
// }