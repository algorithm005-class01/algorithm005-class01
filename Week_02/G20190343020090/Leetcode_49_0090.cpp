class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> group_map;
        vector<vector<string>> res;
        for (string str : strs) {
            string tmp = str;
            sort(tmp.begin(), tmp.end());
            group_map[tmp].push_back(str);
        }
        for (auto it = group_map.begin(); it != group_map.end(); ++it)
        {
            res.push_back(it->second);
        }

        return res;
    }
};