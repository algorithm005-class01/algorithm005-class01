class Solution {
public:
    int lengthOfLastWord(string s) {
        int res = 0;
        int restemp = 0;      
        int len = s.size();
        if(len == 0)
            return 0;
        for(int i = 0;i < len; i++)
        {
            if(s[i] == ' '){
                if(res != 0)
                    restemp = res;
                res = 0;
            }
            else{
                restemp = 0;
                res++;
            }
        }
        if(restemp!=0)
            res = restemp;
        return res;
    }
};