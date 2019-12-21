#include <iostream>
#include <vector>
using namespace std;

void vec_swap(vector<int>& nums, int begin, int end)
{
    while (begin < end) {
	swap(nums[begin], nums[end]);
	++begin;
	--end;
    }
}

void rotate(vector<int>& nums, int k)
{
    if (k == 0)
	return;
    if (nums.size() == 0)
	return;

    int tok = (k % nums.size());
    vec_swap(nums, 0, nums.size() - tok - 1);
    vec_swap(nums, nums.size() - tok, nums.size() - 1);
    vec_swap(nums, 0, nums.size() - 1);
}

int main(int argc, char* argv[])
{
    vector<int> a = { 1, 2, 3, 4, 5, 6, 7 };
    rotate(a, 3);
    for (int i = 0; i != a.size(); ++i) {
	cout << a[i] << " ";
    }
    cout << endl;
    return 0;
}
