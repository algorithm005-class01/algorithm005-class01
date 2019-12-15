class PlusOne {

    class Solution {
        public int[] plusOne(int[] digits) {
            int temp = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                temp += digits[i];
                digits[i] = temp % 10;
                temp /= 10;
            }
            if (temp == 1) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                digits = newDigits;
            }
            return digits;
        }
    }

}