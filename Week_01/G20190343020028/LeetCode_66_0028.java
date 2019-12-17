//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        // 主要需要考虑进位处理
        // 自右向左处理
        for (int i = digits.length - 1; i >= 0; i--) {
            // 当前位 + 1
            digits[i]++;
            // 取个位数（用来判断是否进位）
            digits[i] = digits[i] % 10;
            // 没有发生进位，则当前数组即结果
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 如果原有位都进行了加一，仍有进位，则最左增加一位 1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
