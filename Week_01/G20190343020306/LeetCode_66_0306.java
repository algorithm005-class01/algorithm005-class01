class Solution {
    public int[] plusOne(int[] digits) {
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (++digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        //如果到这里肯定是需要扩位的, 那么直接初始化一个多一位的数组
        int[] newDigits = new int[digits.length + 1]; //初始出来的数字肯定都是0
        newDigits[0] = 1;
        return newDigits;
    }
}