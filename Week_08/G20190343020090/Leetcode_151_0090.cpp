class Solution {
public:
    string reverseWords(string s) {
        int len = s.size();
        bool first = true;
        for (int i = len - 1; i >= 0; i--)
        {
            if (s[i] != ' ')
            {
                int j = i;
                while (j >= 0 && s[j] != ' ')
                    j--;
                int w = j + 1;
                if(!first)
                    s.push_back(' ');
                while (w <= i)
                    s.push_back(s[w++]);
                i = j;
                first = false;
            }
            
        }
        return s.substr(len, s.size()-len);
    }
};