//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, String> phone = new HashMap<>();

        List<String> output = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return output;
            }
            phone.put("2", "abc");
            phone.put("3", "def");
            phone.put("4", "ghi");
            phone.put("5", "jkl");
            phone.put("6", "mno");
            phone.put("7", "pqrs");
            phone.put("8", "tuv");
            phone.put("9", "wxyz");
            recursive("", digits, 0);
            return output;
        }

        private void recursive(String s, String digits, int i) {
            //terminator
            if (i == digits.length()) {
                output.add(s);
                return;
            }
            //process
            String s1 = phone.get(digits.charAt(i) + "");
            for (int j = 0; j < s1.length(); j++) {
                recursive(s + s1.charAt(j), digits, i + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}