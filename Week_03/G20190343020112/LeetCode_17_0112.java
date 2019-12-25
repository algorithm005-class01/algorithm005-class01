class Solution {
    private Map<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        return backtrack(digits, 0, sb);
    }

    private List<String> backtrack(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return res;
        }

        String str = map.get(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        return res;
    }

}