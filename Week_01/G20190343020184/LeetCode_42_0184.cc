#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int trap(vector<int>& height)
{
    if (height.size() == 0)
	return 0;
    int recmaxl[height.size()];
    int recmaxr[height.size()];

    recmaxl[0] = 0;
    recmaxr[height.size() - 1] = 0;

    for (int i = 1; i < height.size(); ++i) {
	recmaxl[i] = max(height[i - 1], recmaxl[i - 1]);
	recmaxr[height.size() - 1 - i] = max(height[height.size() - i], recmaxr[height.size() - i]);
    }

    int res = 0;

    for (int i = 1; i < height.size() - 1; ++i) {
	int left = recmaxl[i];
	int right = recmaxr[i];
	res += max(min(left, right) - height[i], 0);
    }
    return res;
}

int main(int argc, char* argv[])
{
    vector<int> a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    cout << trap(a) << endl;
    return 0;
}
