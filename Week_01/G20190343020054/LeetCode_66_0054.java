public class LeetCode_66_0054 {
    /**
     * 加一只有两种情况
     * <p>
     * - 除 9 之外的数字加一；
     * - 数字 9。
     * <p>
     * 加一的 10，个位数为 0，加法运算如果不出现进位就结束，如果有进位，只能是 1。
     * <p>
     * 所以只需要判断是否有进位，当有进位时，当前值为 0，只需要判断当前值不是 0 时，进位就全部完成，然后退出循环返回结果即可。
     * <p>
     * 如果所有的都是 0，那么就是出现了 99，999，9999 之类的数字，那此时在新建一个比原来数组大一位的数组，然后设置首位是 1 即可。
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
