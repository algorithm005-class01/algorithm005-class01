//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        // 剔除非字母、数字字符
        String filteredS = validString(s);
        // 反转字符
        String reversedS = reverseString(filteredS);
        // 忽略大小写比较
        return filteredS.equalsIgnoreCase(reversedS);
    }

    private String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String validString(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
