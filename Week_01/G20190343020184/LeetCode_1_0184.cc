#include <iostream>
#include <map>
#include <vector>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target)
{
    vector<int> res;
    map<int, int> resset;
    for (int i = 0; i != nums.size(); ++i) {
	if (resset.find(target - nums[i]) != resset.end()) {
	    res.push_back(resset[target - nums[i]]);
	    res.push_back(i);
	    break;
	}
	resset.insert(make_pair(nums[i], i));
    }
    return res;
}

int main()
{
    vector<int> a = { 2, 7, 11, 15 };
    auto p = twoSum(a, 9);
    for (int i = 0; i != a.size(); ++i) {
	cout << a[i] << " ";
    }
    cout << endl;
}
