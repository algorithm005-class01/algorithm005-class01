class Solution {
    //K个一组反转或不反转
    public String reverseStr(String s, int k) {
        int i = 0, j = Math.min(k - 1, s.length() - 1);
        boolean isReverse = true;
        StringBuilder sb = new StringBuilder();
        while (i <= s.length() - 1) {
            if (isReverse) {
                //reverse i..j
                sb.append(reverse(s, i, j));
            } else {
                sb.append(s.substring(i, j + 1));
            }
            isReverse = !isReverse;
            i += k;
            j = Math.min(j + k, s.length() - 1);
        }
        return sb.toString();
    }

    private String reverse(String s, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int k = j; k >= i; k--) {
            sb.append(s.charAt(k));
        }
        return sb.toString();
    }
}