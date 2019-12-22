public boolean is Anagram(String s, String t) {
    if (s.length() != t.length()) return fasle;
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
    }

}