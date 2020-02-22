class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int len_j = J.size();
        int len_s = S.size();
        int ret = 0;
        for(int i = 0;i < len_j ;i++){
            for(int j = 0;j < len_s;j++){
                if(J[i] == S[j]) 
                    ret++;
            }
        }
        return ret;
    }
};