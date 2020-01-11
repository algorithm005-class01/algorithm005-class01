#include <iostream>
#include <vector>
using namespace std;

//这个想法是正常能够获得答案的。
int jump1(vector<int>& nums)
{
    int position = nums.size() - 1; //要找的位置
    int steps = 0;
    while (position != 0) { //是否到了第 0 个位置
	for (int i = 0; i < position; i++) {
	    if (nums[i] >= position - i) {
		position = i; //更新要找的位置
		steps++;
		break;
	    }
	}
    }
    return steps;
}

//题目本身就是有问题的，如果数组里面存在0的情况下
//不能正常结束。
int jump(vector<int>& nums)
{
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < nums.size() - 1; i++) {
	maxPosition = max(maxPosition, nums[i] + i);
	if (i == end) {
	    end = maxPosition;
	    steps++;
	}
    }
    return steps;
}

int main(int argc, char* argv[])
{

    return 0;
}
