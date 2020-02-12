class LeetCode_151_0190 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] strings = s.split(" +");
        if (strings.length == 0) return "";
        else if (strings.length == 1) return strings[0];
        int start = 0, end = strings.length - 1;
        while (start < end) {
            String temp = strings[start];
            strings[start++] = strings[end];
            strings[end--] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (string.length() == 0) continue;
            sb.append(string).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}