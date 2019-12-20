class Solution {
    public int[] plusOne(int[] digits) {
        for ( int i = digits.length - 1; i >= 0; i--) {
            if (++digits[i] <= 9) {
                // 没有发生进位，可以直接返回了
                return digits;
            }else if (i > 0){
                digits[i] = 0;
            }
        }
        if (digits[0] <= 9) {
            return digits;
        }else {
            int[] ret = new int[digits.length + 1]; 
            ret[0] = 1;
            return ret;
        }
    }
}