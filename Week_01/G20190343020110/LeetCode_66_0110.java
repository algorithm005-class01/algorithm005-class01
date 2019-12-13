/**
 * @Author huangxiong
 * @Date 2019/12/14
 * @Description leetcode题目 66
 **/
public class LeetCode_66_0110 {


    /**
     * 暴力解法
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    /**
     * 递归解法
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        return helper(digits,digits.length-1);
    }

    private int[] helper(int[] digits, int index){
        if(digits[index] < 9){
            digits[index]++;
            return digits;
        }else{
            if(index != 0){
                digits[index] = 0;
                return helper(digits,index-1);
            }else{
                int[] res = new int[digits.length+1];
                res[0] = 1;
                return res;
            }
        }
    }
}
