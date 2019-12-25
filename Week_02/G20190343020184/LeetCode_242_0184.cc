#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

//击败17%
bool isAnagram(string s, string t)
{

    if (s.size() != t.size()) {
	return false;
    }
    map<char, int> recmap;

    for (int i = 0; i < s.size(); ++i) {
	if (recmap.find(s[i]) == recmap.end()) {
	    recmap.insert({ s[i], 1 });
	} else {
	    ++recmap[s[i]];
	}
    }

    for (int i = 0; i < t.size(); ++i) {
	if (recmap.find(t[i]) == recmap.end()) {
	    return false;
	} else if (recmap[t[i]] == 0) {
	    return false;
	} else {
	    --recmap[t[i]];
	}
    }
    return true;
}

//击败34%
bool isAnagram2(string s, string t)
{
    if (s.size() != t.size()) {
	return false;
    }
    sort(s.begin(), s.end());
    sort(t.begin(), t.end());
    return s == t;
}

//击败99.82%
bool isAnagram3(string s, string t)
{
    if (s.size() != t.size()) {
	return false;
    }

    vector<int> recmap(26, 0);

    for (int i = 0; i < s.size(); ++i) {
	++recmap[s[i] - 'a'];
    }
    for (int i = 0; i < t.size(); ++i) {
	if (recmap[t[i] - 'a'] == 0) {
	    return false;
	} else {
	    --recmap[t[i] - 'a'];
	}
    }
    return true;
}

int main(int argc, char* argv[])
{
    string a = "rat";
    string b = "car";
    cout << isAnagram3(a, b) << endl;
    return 0;
}
