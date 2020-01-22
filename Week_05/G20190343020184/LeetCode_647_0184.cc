#include <iostream>
#include <string>
using namespace std;

int countSubstrings(string s) {
  if (s.size() == 0)
    return 0;
  // dp 是一个表，记录的就是i。。。j是否是一个回文串
  int res = 0;
  bool dp[s.size()][s.size()];

  for (int i = 0; i < s.size(); ++i) {
    for (int j = 0; j < s.size(); ++j) {
      if (i == j) {
        dp[i][j] = true;
      } else {
        dp[i][j] = false;
      }
    }
  }

  for (int len = 2; len < s.size() + 1; ++len) {
    for (int i = 0; i < s.size() - len + 1; ++i) {
      if (s[i] == s[i + len - 1]) {
        if (dp[i + 1][i + len - 2] == true || len == 2) {
          dp[i][i + len - 1] = true;
          if (len > res) {
            res = len;
          }
        }
      }
    }
  }

  return res;
}

int main(int argc, char *argv[]) {

  string a = "aaa";
  cout << countSubstrings(a) << endl;

  return 0;
}
