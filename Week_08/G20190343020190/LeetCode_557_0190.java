class LeetCode_557_0190 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int start = -1, end = -1;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || ' ' == chars[i]) {
                if (start != -1) {
                    end = i - 1;
                    this.doReverse(chars, start, end);
                    start = -1;
                }
            } else if (start == -1) start = i;
        }
        return new String(chars);
    }

    private void doReverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

}