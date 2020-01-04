#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int findContentChildren(vector<int>& g, vector<int>& s)
{
    int res = 0;
    sort(g.begin(), g.end());
    sort(s.begin(), s.end());

    int pointer1 = 0;
    int pointer2 = 0;
    while ((pointer1 < g.size()) && (pointer2 < s.size())) {
	if (s[pointer2] >= g[pointer1]) {
	    ++pointer1;
	    ++pointer2;
	    ++res;
	} else {
	    ++pointer2;
	}
    }
    return res;
}

int main(int argc, char* argv[])
{

    return 0;
}
