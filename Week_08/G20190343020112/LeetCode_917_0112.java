class Solution {
    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        int start = 0, end = cs.length - 1;
        while (start < end) {
            while (start < end && !isLetter(cs[start])) start++;
            while (start < end && !isLetter(cs[end])) end--;
            char tmp = cs[start];
            cs[start++] = cs[end];
            cs[end--] = tmp;
        }

        return new String(cs);
    }

    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'); 
    }
}