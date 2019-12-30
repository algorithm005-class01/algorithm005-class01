/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
*/

class Solution {
    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) return ans;

        LinkedList<String> ans = new LinkedList<String>();

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ans.add("");

		while(ans.peek().length() != digits.length()){

            String remove = ans.remove();
            
            String map = mapping[digits.charAt(remove.length())-'0'];
            
			for(char c: map.toCharArray()){

                ans.addLast(remove+c);
                
			}
		}
        return ans;
    }
}