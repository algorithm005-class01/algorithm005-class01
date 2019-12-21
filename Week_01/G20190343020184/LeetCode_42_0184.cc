#include <algorithm>
#include <iostream>
#include <stack>
#include <vector>
using namespace std;

/*
 *自己做的，预处理数组
 */
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

/*
 *这道题要求求每一个柱子左右两边最长的柱子，感觉用预处理数组就很好了。
 *下面用栈来做。默写答案版本
*/

int trap2(vector<int>& height)
{
    int ans = 0;
    int current = 0;
    stack<int> sta;
    while (current < height.size()) {
	while (!sta.empty() && height[current] > height[sta.top()]) {
	    int top = sta.top();
	    sta.pop();
	    if (sta.empty())
		break;
	    int distance = current - sta.top() - 1;
	    int bounded_height = min(height[current], height[sta.top()]) - height[top];
	    ans += distance * bounded_height;
	}
	sta.push(current);
	++current;
    }
    return ans;
}

int main(int argc, char* argv[])
{
    vector<int> a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    cout << trap(a) << endl;
    return 0;
}
