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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(res, map, digits, "", 0);
        return res;
    }

    public void helper(List<String> res, Map<Character, String> map, String digits, String temp, int index) {
        if (index == digits.length()) {
            res.add(temp);
            return;
        }
        String letters = map.get(digits.charAt(index));

        for (int i = 0; i < letters.length(); i++) {
            helper(res, map, digits, temp + letters.charAt(i), index + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
