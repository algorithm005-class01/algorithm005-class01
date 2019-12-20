package G20190343020064;


/**
 * <p>
 * 加一
 * </p>
 *
 * @author mingke  2019-12-12 4:54 下午
 */
public class LeetCode_66_0064 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int result = digits[i] + 1;
            if (result < 10) {
                digits[i] = result;
                break;
            } else {
                digits[i] = result % 10;
            }
            if (result >= 10 && i == 0) {
                int[] newDig = new int[digits.length + 1];
                System.arraycopy(digits,0,newDig,1,digits.length);
                newDig[0] = 1;
                return newDig;
            }
        }
        return digits;
    }

}
