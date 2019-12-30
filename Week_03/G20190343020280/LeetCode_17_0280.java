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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.isEmpty()) {
            return result;
        }
        Map<Character, String> map = initData(digits);
        letterCombinations(digits, map, "", result);
        return result;
    }

    private void letterCombinations (String didits, Map<Character, String> map, String combine, List<String> result) {
        if (didits.length()==0) {
            result.add(combine);
            return;
        }
        String mapStr = map.get(didits.charAt(0));
        didits = didits.substring(1);
        for (int i = 0; i < mapStr.length(); i++) {
            letterCombinations(didits, map, combine+mapStr.charAt(i), result);
        }

    }

    private Map<Character, String> initData (String digits) {
        String[] array = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < digits.length(); i++) {
            map.put(digits.charAt(i),array[digits.charAt(i)-'2']);
        }
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
