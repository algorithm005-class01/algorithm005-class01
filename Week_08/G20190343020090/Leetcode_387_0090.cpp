class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> times(26, 0);

        for(int i = 0; i < s.size(); i++)
        {
            times[s[i] - 'a']++;
        }

        for(int i = 0; i < s.size(); i++)
        {
            if(times[s[i] - 'a'] == 1)
            {
                return i;
            }
        }

        return -1;
    }
};