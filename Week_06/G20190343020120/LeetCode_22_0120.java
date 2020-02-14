public class LeetCode_22_0120 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        _generate(0,0,n,"");
        return res;
    }
    public void _generate(int left,int right,int n,String s){
        //terminator
        if(left==n&&right==n){
            res.add(s);
            return;
        }
        if(left<n){
            _generate(left+1,right,n,s+"(");
        }
        if(right<left&&right<n){
            _generate(left,right+1,n,s+")");
        }
    }
}
