class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
            }
            else {
                ++ digits[i];
                return digits;
            }
        }
        
        int[] newnums = new int[digits.length + 1];
        newnums[0] = 1;
        return newnums;
    }
}