package Week2_0106;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] sArr = new int[26];
        int[] tArr = new int[26];

        for (int i = 0; i < t.length(); i++) {
            ++sArr[s.charAt(i) - 'a'];
            ++tArr[t.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }
}
