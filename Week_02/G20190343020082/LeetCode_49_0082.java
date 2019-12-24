public class LeetCode_49_0082 {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> resultMap = new HashMap<>();
		for (int i = 0; i < strs.length; i ++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			resultMap.computeIfAbsent(String.valueOf(chars), x -> new ArrayList<>()).add(strs[i]);
		}
		return new ArrayList(resultMap.values());
	}
}