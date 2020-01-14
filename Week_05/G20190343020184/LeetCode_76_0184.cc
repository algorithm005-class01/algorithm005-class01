#include <iostream>
#include <string>
#include <map>
#include <climits>
using namespace std;

string minWindow(string s, string t) {
  string ans = "";
  map<char, int> lettercount;
  for (char c : t)
    ++lettercount[c];
  int count = 0, left = 0, minlen = INT_MAX;
  for (int i = 0; i < s.size(); ++i) {
    if (--lettercount[s[i]] >= 0)
      ++count;
    while (count == t.size()) {
      if (minlen > i - left + 1) {
        minlen = i - left + 1;
        ans = s.substr(left, minlen);
      }
      if (++lettercount[s[left]] > 0)
        --count;
      ++left;
    }
  }
  return ans;
}

int main(int argc, char *argv[]) { return 0; }
