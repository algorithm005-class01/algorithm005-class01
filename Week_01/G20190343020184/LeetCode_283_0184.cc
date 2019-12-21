#include <iostream>
#include <vector>

using namespace std;

void moveZeros(vector<int>& nums)
{
    if (nums.size() == 0)
	return;
    int pointer1 = -1;
    int pointer2 = 0;
    while (pointer2 < nums.size()) {
	if (nums[pointer2] != 0) {
	    swap(nums[pointer1 + 1], nums[pointer2]);
	    ++pointer1;
	}
	++pointer2;
    }
}

int main()
{
    vector<int> a = { 1, 2, 3, 4, 5 };
    moveZeros(a);
    for (int i = 0; i != a.size(); ++i) {
	cout << a[i] << " ";
    }
    cout << endl;
}
