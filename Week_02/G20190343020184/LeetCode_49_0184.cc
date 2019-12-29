#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

//26.44%
vector<vector<string>> groupAnagrams(vector<string>& strs)
{
    if (strs.size() == 0) {
	return {};
    }
    map<string, vector<string>> recmap;
    for (int i = 0; i < strs.size(); ++i) {
	string temp = strs[i];
	sort(temp.begin(), temp.end());
	if (recmap.find(temp) == recmap.end()) {
	    recmap.insert({ temp, { strs[i] } });
	} else {
	    recmap[temp].push_back(strs[i]);
	}
    }

    vector<vector<string>> res;

    for (auto p = recmap.begin(); p != recmap.end(); ++p) {
	vector<string> temp = p->second;
	res.push_back(temp);
    }
    return res;
}

int main(int argc, char* argv[])
{
    vector<string> a = { "eat", "tea", "tan", "ate", "nat", "bat" };
    auto p = groupAnagrams(a);

    for (int i = 0; i < p.size(); ++i) {
	cout << "---------------------------------" << endl;
	for (int j = 0; j < p[i].size(); ++j) {
	    cout << p[i][j].data() << endl;
	}
	cout << "---------------------------------" << endl;
    }
    return 0;
}
