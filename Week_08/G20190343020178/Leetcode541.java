




class Solution541 {
    public String reverseStr(String s, int k) {
        char[] as = s.toCharArray();
        for (int start = 0; start < as.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, as.length - 1);
            while (i < j) {
                char tmp = as[i];
                as[i++] = as[j];
                as[j--] = tmp;
            }
        }
        return new String(a);
    }
}