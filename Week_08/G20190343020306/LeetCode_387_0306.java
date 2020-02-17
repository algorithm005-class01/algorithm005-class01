class Solution {
    //计数排序法
    public int firstUniqChar(String s) {
        if (s.length() <= 1) {
            return s.length() - 1; //长度0返回-1, 长度1返回0
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}