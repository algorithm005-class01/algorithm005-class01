class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] count = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[(int)s.charAt(i)]++;
            count[(int)t.charAt(i)]--;
        } 
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}