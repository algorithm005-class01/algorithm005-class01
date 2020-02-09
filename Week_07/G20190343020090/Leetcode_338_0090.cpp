class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans(num+1, 0);
        int i = 0; 
        int b = 1;
        while (b <= num)
        {
            while (i < b && i + b <= num)
            {
                ans[i+b] = ans[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }

        return ans;
    }
};