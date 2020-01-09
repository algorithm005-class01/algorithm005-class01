#include <iostream>
#include <vector>
using namespace std;

int jump(vector<int>& nums)
{
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < nums.size() - 1; i++) {
	//找能跳的最远的
	maxPosition = max(maxPosition, nums[i] + i);
	if (i == end) { //遇到边界，就更新边界，并且步数加一
	    end = maxPosition;
	    steps++;
	}
    }
    return steps;
}

int main(int argc, char *argv[])
{
	
	return 0;
}
