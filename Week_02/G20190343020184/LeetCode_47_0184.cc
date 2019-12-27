#include <iostream>
#include <set>
#include <vector>
using namespace std;

//就是简单改了改
class Solution {
public:
    void proccess(vector<int>& nums, int cur, vector<vector<int>>& resv)
    {
	if (cur == nums.size()) {
	    resv.push_back(nums);
	    return;
	}
	set<int> head;
	for (int i = cur; i < nums.size(); ++i) {
	    if (head.find(nums[i]) == head.end() || i == cur) {
		head.insert(nums[i]);
		swap(nums[cur], nums[i]);
		proccess(nums, cur + 1, resv);
		swap(nums[cur], nums[i]);
	    }
	}
    }

    vector<vector<int>> permuteUnique(vector<int>& nums)
    {
	vector<vector<int>> resv;
	proccess(nums, 0, resv);
	return resv;
    }
};

int main(int argc, char* argv[])
{

    return 0;
}
