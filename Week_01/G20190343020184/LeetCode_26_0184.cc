#include <iostream>
#include <vector>
using namespace std;

int removeDuplicates(vector<int>& nums)
{
    if (nums.size() == 0) {
	return 0;
    }
    int pointer1 = 0;
    int pointer2 = 0;
    while (pointer2 < nums.size()) {
	if (nums[pointer1] != nums[pointer2]) {
	    nums[pointer1 + 1] = nums[pointer2];
	    ++pointer1;
	}
	++pointer2;
    }
    return pointer1 + 1;
}

int main(int argc, char* argv[])
{
    vector<int> a = { 1, 2, 3, 4 };
    cout << removeDuplicates(a) << endl;
    return 0;
}
