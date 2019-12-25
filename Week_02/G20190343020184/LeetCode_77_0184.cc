#include <iostream>
#include <vector>
using namespace std;

void pro(vector<int>& nums, int now, int k, vector<int>& temp, vector<vector<int>>& res)
{
    if (now == nums.size()) {
	if (k == 0) {
	    res.push_back(temp);
	}
	return;
    }
    int counter = temp.size();
    pro(nums, now + 1, k, temp, res);
    temp.resize(counter);
    temp.push_back(nums[now]);
    pro(nums, now + 1, k - 1, temp, res);
    temp.resize(counter);
}

vector<vector<int>> combine(int n, int k)
{
    vector<int> nums;
    for (int i = 1; i <= n; ++i) {
	nums.push_back(i);
    }
    vector<int> temp;
    vector<vector<int>> res;
    pro(nums, 0, k, temp, res);
    return res;
}

//参考别人的写法，更快些，思路完全一致

class Solution {
public:
    vector<int> nums;
    vector<vector<int>> ans;
    void backtrack(vector<int> cur, int n, int k, int left)
    {
	if (cur.size() == k) {
	    ans.push_back(cur);
	    return;
	}
	//for (int i = left; i < n; i++)
	for (int i = left; i <= n - (k - cur.size()); i++) {
	    int nu = nums[i];
	    cur.push_back(nu);
	    backtrack(cur, n, k, i + 1);
	    cur.pop_back();
	}
    }
    vector<vector<int>> combine(int n, int k)
    {
	for (int i = 1; i <= n; i++)
	    nums.push_back(i);
	vector<int> cur;
	backtrack(cur, n, k, 0);
	return ans;
    }
};

int main(int argc, char* argv[])
{

    return 0;
}
