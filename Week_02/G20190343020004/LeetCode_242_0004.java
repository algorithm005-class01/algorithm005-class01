public class LeetCode_242_0004 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (char c : charsS) {
            counts[c - 'a']++;
        }
        for (char c : charsT) {
            int index = c - 'a';
            int count = counts[c - 'a'];
            if (count > 0) {
                counts[c - 'a'] = count - 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
