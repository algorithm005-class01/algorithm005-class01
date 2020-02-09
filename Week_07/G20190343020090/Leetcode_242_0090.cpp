class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length())
            return false;
        unordered_map<int, int> umap;
        for (int i = 0; i < s.length(); i++)
        {
            ++umap[s[i]];
            --umap[t[i]];
        }
        for (auto a : umap) {
            if (a.second != 0)
                return false;
        }
        return true;
    }
};