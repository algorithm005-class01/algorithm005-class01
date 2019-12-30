import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    Map<Character, String> phone = new HashMap<Character, String>();
        


    public List<String> letterCombinations(String digits) {
        // return backtracking(digits);
        return arrayListMethod(digits);
    }



    /**
     * 二. 队列法：同样需要构建字母对应map,并申请一个结果队列（首先向其中放一个空串）。外层循环给定字符串，
     *          每层中拿到对应的字符集合。首先假设给定字符串只有一个，那么查看结果队列中的大小，并将其中每一个都
     *          拿出来拼接字符串对应的字符。然后给定字符串有两个，那么依次将队列中的值拿出来，循环拼接字符串集合。
     *          依此类推。
     * 复杂度分析：
     *      时间：O(3^n)
     *      空间：O(2^n)
     * @param digits
     * @return
     */
    public List<String> arrayListMethod(String digits){
        if(digits==null || digits.length()==0) {
			return new ArrayList<String>();
		}
		//一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
		//这里也可以用map，用数组可以更节省点内存
		String[] letter_map = {
			" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
		};
		List<String> res = new ArrayList<>();
		//先往队列中加入一个空字符
		res.add("");
		for(int i=0;i<digits.length();i++) {
			//由当前遍历到的字符，取字典表中查找对应的字符串
			String letters = letter_map[digits.charAt(i)-'0'];
			int size = res.size();
			//计算出队列长度后，将队列中的每个元素挨个拿出来
			for(int j=0;j<size;j++) {
				//每次都从队列中拿出第一个元素
				String tmp = res.remove(0);
				//然后跟"def"这样的字符串拼接，并再次放到队列中
				for(int k=0;k<letters.length();k++) {
					res.add(tmp+letters.charAt(k));
				}
			}
		}
		return res;
    }


    /**
     * 一.回溯法: 是一种优先搜索算法，首先找到这个题的重复地方。
     *          创建一个递归方法，参数有逐渐生成的字符串，原始字符，层级（用来对应该层要拼接哪些字符串和结束条件）
     *          结果集，结束条件就是层级等于给定字符串的长度，意思是没有再拼接的字母了，然后返回结果
     * 复杂度分析：(n是每个数字对应字母数目，m是输入的字母的数目)
     *      时间：O(3^n * 4^m)
     *      空间：O(3^n * 4^m)
     * 
     * @param digits
     * @return
     */
    public List<String> backtracking(String digits){
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length()<1) {
            return res;
        }
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
       
        search("", digits, 0, res);
        return res;   
    }
    /**
     * 
     * @param s         截至到目前生成的字符串
     * @param digits    给定的字符串
     * @param i         层数    
     * @param res       结果集合
     */
    private void search(String s,String digits,int i,List<String> res){
        //terminator
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        //process
        String letters = phone.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            search(s+letters.charAt(j), digits, i+1, res);
        }
    }
}
// @lc code=end

