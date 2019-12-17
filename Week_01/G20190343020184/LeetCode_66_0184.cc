#include <iostream>
#include <vector>
using namespace std;

vector<int> plusOne(vector<int>& digits)
{
    if (digits.size() == 0)
	return {};

    int jin = 1;

    vector<int> res;
    res.resize(digits.size() + 1);

    auto p = digits.end() - 1;
    auto q = res.end() - 1;
    while (p != digits.begin() - 1) {
	int t = jin;
	jin = (*p + jin) / 10;
	*q = (*p + t) % 10;
	--p;
	--q;
    }

    if (jin == 1) {
	res[0] = 1;
	return res;
    }
    return { res.begin() + 1, res.end() };
}

int main(int argc, char* argv[])
{

    return 0;
}
