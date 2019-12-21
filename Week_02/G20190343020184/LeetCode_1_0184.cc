#include <iostream>
#include <map>
#include <vector>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target)
{
    map<int, int> recmap;

    for (int i = 0; i < nums.size(); ++i) {
	if (recmap.find(target - nums[i]) != recmap.end()) {
	    return { recmap[target - nums[i]], i };
	} else {
	    recmap.insert({ nums[i], i });
	}
    }
    return {};
}

int main(int argc, char* argv[])
{
    vector<int> a = { 2, 7, 11, 15 };
    auto p = twoSum(a, 9);
    cout << p[0] << " " << p[1] << endl;
    return 0;
}
