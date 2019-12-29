public class LeetCode_66_0190 {
    public int[] plusOne(int[] digits) {
        int remain = -1;
        int index = digits.length - 1;
        while (remain != 0 && index >= 0) {
            int sum = digits[index] + 1;
            digits[index] = sum % 10;
            remain = sum / 10;
            index--;
        }
        if (remain > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = remain;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}
