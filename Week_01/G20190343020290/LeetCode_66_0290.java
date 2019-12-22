import java.util.Arrays;

/**
 * Created by Ju·Felix on 2019/12/15.
 */
public class LeetCode_66_0290 {

    public static void main( String[] args ) {
        int[] test = new int[]{3, 6, 8, 9};

        int[] result = plusOne(test);

        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    /**
     * 66. Plus One [easy]
     * @param digits [1, 3, 5]
     * @return [1, 3, 6]
     */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            ++digits[i];
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = Arrays.copyOf(digits, digits.length + 1);
        digits[0] = 1;
        return digits;
    }
}