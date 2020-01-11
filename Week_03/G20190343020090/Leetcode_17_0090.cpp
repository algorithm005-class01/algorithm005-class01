class Solution {
    map<char, string> phone;
    vector<string> res;
public:
    vector<string> letterCombinations(string digits) {
        phone = { {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"}, {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}};
        if(digits.size() == 0)
            return res;
        backtrack("", 0, digits);
        return res;
    }
    void backtrack(string str, int index, string digits)
    {
        if (index == digits.size())
        {
            res.push_back(str);
            return;
        }

        for ( char ch: phone[digits[index]])
        {
            backtrack(str + ch, index + 1, digits);
        }
    }
};