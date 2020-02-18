class LeetCode_387_0190 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] chars = s.toCharArray();
        int[] array = new int[26];
        for (char c : chars) {
            array[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (array[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}