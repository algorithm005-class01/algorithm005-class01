class Solution
{
public:
    string reverseStr(string s, int k)
    {
        for (int left = 0; left < s.size(); left += 2 * k)
        {
            for (int i = left, j = min(left + k - 1, (int)s.size() - 1); i < j; i++, j--)
            {
                swap(s[i], s[j]);
            }
        }
        return s;
    }
    void swap(char &s1, char &s2)
    {
        char temp = s1;
        s1 = s2;
        s2 = temp;
    }
};