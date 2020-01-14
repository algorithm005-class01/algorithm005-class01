#include <iostream>
#include <vector>
using namespace std;

bool searchMatrix(vector<vector<int>>& matrix, int target)
{
    if (matrix.size() == 0 || matrix[0].size() == 0) {
	return false;
    }

    int maxrow = matrix.size() - 1;
    int maxcol = matrix[0].size() - 1;

    int i = 0;
    int j = maxcol;
    while (i <= maxrow && j >= 0) {
	if (matrix[i][j] == target) {
	    return true;
	} else if (matrix[i][j] > target) {
	    --j;
	} else {
	    ++i;
	}
    }
    return false;
}

int main(int argc, char* argv[])
{

    return 0;
}
