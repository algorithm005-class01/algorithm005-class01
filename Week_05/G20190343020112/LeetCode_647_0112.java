class Solution {
    public int countSubstrings(String s) {
        int length = s.length(), res = 0;
        int centerNums = 2 * length - 1;

        for (int i = 0; i < centerNums; i++) {
            int left = i / 2, right = left + (i & 1);
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }

        }
        return res;
    }
}