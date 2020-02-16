class Solution {
public:
    string reverseStr(string s, int k) {
        int i = 1;
        int left = 0;
        int right = 0;
        while (i * k < s.size())
        {
            left = (i - 1) * k;
            right = i * k - 1;
            while (left < right) 
                swap(s[left++], s[right--]);
                i += 2;
        }

        if ((i - 1) * k < s.size())
        {
            left = (i - 1) * k;
            right = s.size() - 1;
            while (left < right)
                swap(s[left++], s[right--]);
        }

        return s;        
    }
};