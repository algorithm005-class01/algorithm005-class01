class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> map = new HashMap<>(16);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(res, map, 0, digits, "");
        return res;
    }

    private void helper(List<String> res, HashMap<Character, String> map, int index, String digits, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            helper(res, map, index + 1, digits, s + letters.charAt(i));
        }
    }
}