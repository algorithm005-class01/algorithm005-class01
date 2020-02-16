class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" +");
        Collections.reverse(Arrays.asList(strs));
        return String.join(" ", strs);
    }
}