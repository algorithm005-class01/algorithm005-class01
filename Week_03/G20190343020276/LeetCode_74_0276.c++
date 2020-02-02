class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        if(matrix.size() == 0)
            return false;
        int row = matrix.size();
        int column = matrix[0].size();
        int left = 0;
        int right = matrix.size() * matrix[0].size() - 1;

        while(left<=right)
        {
            int mid = left + (right -left + 1)/2;
            int val = matrix[mid / column][mid % column];

            if(target == val)
            {
                return true;
            }
            else if(target > val)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return false;
    }
};