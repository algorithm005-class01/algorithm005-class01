/*
LeetCode 17, 电话号码的组合
思路: 通过回溯法求解
保留层次, 在逐个位置上放置可能出现的字母
放好以后drilldown到下个层次, 把当前放好字母后的字符串传递下去
这里特意复制了一份字符串, 避免回溯时要重置状态
一个比较阴险的test case是空串, 需要返回空
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<String, List<Character>> digitLetterMap = new HashMap<>();
        digitLetterMap.put("2", Arrays.asList('a', 'b', 'c'));
        digitLetterMap.put("3", Arrays.asList('d', 'e', 'f'));
        digitLetterMap.put("4", Arrays.asList('g', 'h', 'i'));
        digitLetterMap.put("5", Arrays.asList('j', 'k', 'l'));
        digitLetterMap.put("6", Arrays.asList('m', 'n', 'o'));
        digitLetterMap.put("7", Arrays.asList('p', 'q', 'r', 's'));
        digitLetterMap.put("8", Arrays.asList('t', 'u', 'v'));
        digitLetterMap.put("9", Arrays.asList('w', 'x', 'y', 'z'));

        List<String> answer = new ArrayList<>();
        int level = 0;
        String currentAnswer = "";
        solve(digits, answer, currentAnswer, digitLetterMap, level);

        return answer;
    }

    private void solve(String digits, List<String> answer, String currentAnswer, Map<String, List<Character>> digitLetterMap, int level) {
        if (digits.length() == 0) {
            return;
        }
        if (level == digits.length()) {
            answer.add(currentAnswer);
            return;
        }
        String currentDigit = String.valueOf(digits.charAt(level));
        List<Character> letters = digitLetterMap.get(currentDigit);

        for (int i = 0; i < letters.size(); i++) {
            String pushDownAnswer = currentAnswer + letters.get(i);
            solve(digits, answer, pushDownAnswer, digitLetterMap, level + 1);
        }
    }
}