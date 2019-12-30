class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0 || matrix[0].size() == 0)
            return false;
        int m = matrix.size();
        int n = matrix[0].size();
        int left = 0;
        int right = m*n - 1;
        while(left < right) {
            int mid  = left + (right - left)/2;
            if (matrix[mid/n][mid%n] == target) {
                return true;
            }
            else if (matrix[mid/n][mid%n] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (matrix[left/n][left%n] == target)
            return true;
        else    
            return false;
    }
};