#include <vector>
#include <climits>
using namespace std;


int minPathSum(vector<vector<int>>& grid)
{
    int m = grid.size();
    int n = grid[0].size();

    if (m == 0 || n == 0)
	return 0;

    long long dp[m][n];
    dp[m - 1][n - 1] = grid[m - 1][n - 1];

    for (int i = m - 1; i >= 0; --i) {
	for (int j = n - 1; j >= 0; --j) {
	    if ((i == m - 1) && (j == n - 1)) {
		continue;
	    }

	    long long t1 = INT_MAX;
	    long long t2 = INT_MAX;
	    if (j + 1 <= n - 1) {
		t1 = dp[i][j + 1];
	    }
	    if (i + 1 <= m - 1) {
		t2 = dp[i + 1][j];
	    }
	    dp[i][j] = min(t1 + grid[i][j], t2 + grid[i][j]);
	}
    }
    return dp[0][0];
}
