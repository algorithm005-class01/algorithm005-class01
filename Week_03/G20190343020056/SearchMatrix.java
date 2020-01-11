public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;


        /**
         * 将矩阵视为 m * n 的数组
         * 右 = m * n - 1
         * 每一个点的坐标：
         *      x: idx / n
         *      y: idx % n
         */
        int left = 0, right = m * n -1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = left + (right - left) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
}