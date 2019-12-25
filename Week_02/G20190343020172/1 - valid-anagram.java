public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
	//  26 位计数器表
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
		// 用一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，
			然后检查计数器是否回到零
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}