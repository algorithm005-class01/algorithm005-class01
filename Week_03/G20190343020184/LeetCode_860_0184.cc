#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
using namespace std;

bool lemonadeChange(vector<int>& bills)
{
    int recmap[21] = { 0 };
    for (int i = 0; i < bills.size(); ++i) {
	if (bills[i] == 5) {
	    ++recmap[5];
	} else if (bills[i] == 10) {
	    if (recmap[5] == 0) {
		return false;
	    }
	    --recmap[5];
	    ++recmap[10];
	} else {
	    if ((recmap[10] > 0) && (recmap[5]) > 0) {
		--recmap[10];
		--recmap[5];
	    } else if (recmap[5] >= 3) {
		recmap[5] -= 3;
	    } else {
		return false;
	    }
	}
    }
    return true;
}

int main(int argc, char* argv[])
{

    return 0;
}
