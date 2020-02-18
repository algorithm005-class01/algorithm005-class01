class LeetCode_917_0190 {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return S;
        char[] chars = S.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            //确定start的位置
            while (start < chars.length && !this.isLetter(chars[start])) start++;
            //确定end的位置
            while (end > 0 && !this.isLetter(chars[end])) end--;
            if (start >= end) break;
            //start、end位置的值交换，交换完成后start++; end--;
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        return new String(chars);
    }

    private boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

}