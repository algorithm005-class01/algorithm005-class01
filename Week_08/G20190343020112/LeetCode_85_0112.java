
class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix != null && matrix.length > 0 ? matrix.length : 0, n = m > 0 ? matrix[0].length : 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);
        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
                maxarea = Math.max(maxarea, height[j] * (right[j] - left[j]));
            }
        }
        return maxarea;
    }
}

// class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         int m = matrix != null && matrix.length > 0 ? matrix.length : 0, n = m > 0 ? matrix[0].length : 0;

//         int[][] dp = new int[m][n];
//         int maxarea = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (matrix[i][j] == '1') {
//                     dp[i][j] = j > 0 ? dp[i][j - 1] + 1 : 1;
//                 }
//                 int k = i;
//                 int minW = dp[i][j];
//                 while (k >= 0) {
//                     minW = Math.min(minW, dp[k--][j]);
//                     maxarea = Math.max(maxarea, minW * (i - k));
//                 }
//             }
//         }
//         return maxarea;
//     }
// }