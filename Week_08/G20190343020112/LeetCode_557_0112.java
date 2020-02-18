class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length;) {
            int start = i;
            while (start < cs.length && cs[start] == ' ') start++;
            int end = start;
            while (end < cs.length && cs[end] != ' ') end++;
            i = end--;
            while (start < end) {
                char tmp = cs[start];
                cs[start++] = cs[end];
                cs[end--] = tmp;
            }
        }
        return new String(cs);
    }
}