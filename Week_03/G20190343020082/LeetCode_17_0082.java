public class LeetCode_17_0082 {
	public List<String> letterCombinations(String digits) {
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		List<String> result = new ArrayList<>();
		if (digits.length() > 0) recur(0, digits, result, "", map);
		return result;
	}

	private void recur(int level, String digits, List<String> results, String result, Map<Character, String> map) {
		if (level == digits.length()) {
			results.add(result);
			return;
		}
		String s = map.get(digits.charAt(level));
		for (int i = 0; i < s.length(); i ++) {
			recur(level + 1, digits, results, result + s.charAt(i), map);
		}

	}
}