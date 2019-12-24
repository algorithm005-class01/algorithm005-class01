//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 暴力法：将递归生成所有可能的括号
     * 对每个生成的括号判断其合法性
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(char[2 * n],0,res);
        return res
    }
    //生成所有括号的递归方法
    public void generateAll(char[] curr,int pos,List<String> res){
        if(pos == curr.length){
            if(valid(curr)){res.add(new String(curr));}
            return;//若不返回，下面代码会数组越界异常
        }
        curr[pos] = '(';
        generateAll(curr,pos+1,res);
        curr[pos] = ')';
        generateAll(curr,pos+1,res);
    }
    //传递一个字符数组，判断其是否为合法括号
    public boolean valid(char[] curr){
        int count = 0;
        for (char c : curr) {
            if(c == '('){
                count++;
            }else {
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return (count == 0);
    }

    /**
     * 方法二：回溯法。每次生成时候都需要判断当前括号是否合法
     * 通过跟踪左右括号的数量做到这一点
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }
    public void backtrack(List<String> res,String curr,int left,int right,int max){
        if(curr.length() == 2 * max){
            res.add(curr);
            return;//重要！！！
        }
        if(left < max){
            backtrack(res,curr+"(",left+1,right,max);
        }
        if(right < left){
            backtrack(res,curr+")",left,right+1,max);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
