class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int dk = k << 1;
        for (int i = 0; i < cs.length; i += dk) {
            int left = i, right = Math.min(left + k - 1, cs.length - 1);
            while (left < right) {
                char tmp = cs[left];
                cs[left++] = cs[right];
                cs[right--] = tmp;
            }
        }
        return new String(cs);
    }
}

// class Solution {
//     public String reverseStr(String s, int k) {
//         int length = 0;
//         if (s == null || (length = s.length()) == 0) return "";

//         int rlen = length >= k ? k : length;
//         int dk = k << 1;
//         int olen = length >= dk ? k : length - rlen;
//         int remain = rlen + olen;
//         char[] cs = new char[rlen + olen];
        
//         for (int i = 0; i < rlen; i++) {
//             cs[i] = s.charAt(rlen - i - 1);
//         }
//         for (int i = 0; i < olen; i++) {
//             cs[i + rlen] = s.charAt(i + rlen);
//         }
//         return String.valueOf(cs) + reverseStr(s.substring(remain), k);
//     }
// }