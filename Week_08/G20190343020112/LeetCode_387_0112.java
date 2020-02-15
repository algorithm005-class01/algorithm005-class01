class Solution {
    public int firstUniqChar(String s) {
        if (s == null) return 0;
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[(int)s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[(int)s.charAt(i)] == 1) return i;
        }
        return -1;
    }
}