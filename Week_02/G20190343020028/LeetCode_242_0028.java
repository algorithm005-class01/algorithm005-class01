//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        // 长度不一致，则必定不是异位词
        if (s.length() != t.length()) {
            return false;
        }
        // 字母的 ascii 码值，可当做 hash 表容量桶
        // 每个字母位用来统计该字母出现的频次
        int[] ascii = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // str.chat(i) 是字符串第 i 位的字符
            // char 类型本身对应一个 ascii 值， 减法可以得到两个字符码值差额
            // 题干默认都是小写字母，减 a 所得即 0 - 25 hash 桶下标

            // 用 s 字符串增加统计对应字母出现频次
            // 用 t 字符串减少统计对应字母出现频次
            ascii[s.charAt(i) - 'a']++;
            ascii[t.charAt(i) - 'a']--;
        }

        // 如果存在某一字母位，频次不为 0，即不是异位词
        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] != 0) {
                return false;
            }
        }

        // 如果频次都为 0，即异位词
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
