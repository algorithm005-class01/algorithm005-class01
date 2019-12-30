class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // get target row
        int[] targetRow = null;
        for (int i = 0; i < matrix.length; ++i) {
            int[] curr = matrix[i];
            if (curr.length == 0) continue;
            if (target >= curr[0] && target <= curr[curr.length - 1]) {
                targetRow = curr;
                break;
            }
        }
        if (targetRow == null) return false;
        //  search target
        int left = 0;
        int right = targetRow.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (targetRow[mid] == target) return true;
            else if (targetRow[mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return false;
    }
}

