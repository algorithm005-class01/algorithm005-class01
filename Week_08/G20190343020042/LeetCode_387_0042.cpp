class Solution {
public:
    int firstUniqChar(string s) {
        int char_26[26] = {0};
        int len = s.size();
        for(int i=0;i<len;i++){
            char_26[s[i]-'a']++;
        }
        for(int i=0;i<len;i++){
            if(char_26[s[i]-'a']==1)
                return i;
        }
        return -1;
    }
};