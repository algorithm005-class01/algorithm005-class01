package main.leetcode_solutions.array;

/**
 * @author wenzhuang
 * @date 2019/12/15
 */
public class T66_PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] + 1 < 10){
                digits[i] += 1;
                break;
            }
            digits[i] = 0;
            i--;
        }
        if (digits[0] == 0){
            int[] nDigits = new int[digits.length + 1];
            nDigits[0] = 1;
            return nDigits;
        }
        return digits;
    }
}
