class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {            
             return 0;
        }
        int sub1 = 1;
        int sub2 = 1;
        for (int i = s.length() - 2; i > -1; i--) {
            if (s.charAt(i+1) == '0') {
               sub1 = 0;
            }
           if (Integer.parseInt(s.substring(i,i+2)) <= 26) {
                sub1 = sub1 + sub2;
                sub2 = sub1 - sub2;
            } else {
                sub2 = sub1;
            }
        }
        return sub1;
    }
}
