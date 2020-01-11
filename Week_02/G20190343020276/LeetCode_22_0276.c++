class Solution {

    vector<string> vec;
    void recursion(int left,int right,int max,string s)
    {
        if(left == max && right == max)
        {
            vec.push_back(s);
            return;
        }

        if(left <= max)
            recursion(left+1,right,max,s + "(");
        
        if(right < left)
            recursion(left,right + 1,max,s + ")");
        
    }
public:
    vector<string> generateParenthesis(int n) {
        recursion(0,0,n,"");
        return vec;
    }
};