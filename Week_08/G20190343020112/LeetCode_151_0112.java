class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.trim().split(" +");

        for (int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         int start = 0;
//         while (start < s.length() && s.charAt(start) == ' ') start++;
//         int end = start;
//         while (end < s.length() && s.charAt(end) != ' ') end++;
//         return end >= s.length() ? s.substring(start) : (reverseWords(s.substring(end)) + " " + s.substring(start, end)).trim();
//     }
// }

// class Solution {
//     public String reverseWords(String s) {
//         String[] strs = s.trim().split(" +");
//         Collections.reverse(Arrays.asList(strs));
//         return String.join(" ", strs);
//     }
// }