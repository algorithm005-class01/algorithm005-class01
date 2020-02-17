string reverseWords(string s) {
    string ans, str;
    vector<string> tmp;
    stringstream ss(s);
    while (ss >> str) tmp.push_back(str);
    for (int i = tmp.size() - 1; i >= 0; i--) ans += tmp[i] + " ";
    return ans.size() ? string(ans.begin(), ans.end() - 1) : "";
}
