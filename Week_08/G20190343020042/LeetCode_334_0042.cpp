class Solution {
public:
    void reverseString(vector<char>& s) {
        if(s.size() <= 1) return;
        for(int i = 0, j= s.size() - 1 ;i < j ; ++i, --j){
            char tmp = s[i]; s[i] = s[j]; s[j] = tmp;
        }
    }
};