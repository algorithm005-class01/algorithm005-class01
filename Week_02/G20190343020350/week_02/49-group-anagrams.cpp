class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map <string, vector<string>> str_map;
        vector<vector<string>> res;
        for (string str:strs) {
            string tmp = str;
            sort(tmp.begin(), tmp.end());
            str_map[tmp].push_back(str);
        }
        for (const auto&ma:str_map) {
            res.push_back(ma.second);
        }
        return res;
    }
};