class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i)]--;
            if (chars[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}