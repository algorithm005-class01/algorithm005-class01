class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) 
    {
        unordered_map<string,vector<string> > omap;
        vector<vector<string> > results;
        vector<string> v;
        for(int i=0;i<strs.size();i++)
        {
            string s = strs[i];
            sort(s.begin(),s.end());
            omap[s].push_back(strs[i]);
        }

        for(const auto &m:omap)
        {
            results.push_back(m.second);
        }

        return results;
    }
};