class Solution {

    Map<Character, List<String>> dict = new HashMap<Character, List<String>>(){{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        trackback(digits, 0, "", output);
        return output;
    }

    public void trackback(String digits, int index, String comb, List<String> output) {
        if (digits.length() == index) {
            output.add(comb);
            return;
        }
        Character character = digits.charAt(index);
        dict.get(character).forEach(str -> trackback(digits, index + 1, comb + str, output));
    }

}