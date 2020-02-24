class Solution {
public:
    bool is(string s, int i, int j){
        while(i<j){
            if(s[i++] != s[j--])
                return false;
        }
        return true;
    }
    bool validPalindrome(string s) {
        for(int i = 0, j = s.size() - 1; i < j; i++, j--){
            if(s[i] != s[j])
            {
                return is(s, i+1, j) || is(s, i, j-1);
            }
        }
        return true;
    }
};