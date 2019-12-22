package sort.day1;

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 * 哈希表：
 * 1、把第一个字符串的每个字符放到哈希表中，key为字符，value为该字符出现的次数。
 * 第二个字符串从该哈希表中匹配，如果能匹配到该哈希表中所有的字符和出现的个数，
 * 则两个字符串为字母异位词。
 * 时间复杂度为O(n)。
 * <p>
 * 排序：
 * 针对两个字符串进行排序，并比较排序后的结果。
 * 时间复杂度为：排序为O(nlogn)，比较为O(n)，则为最后为O(nlogn)
 */
public class ValidAnagram242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("catt", "tact"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length() || s.isEmpty()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;

        }
        for (int item : counter) {
            if (item != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> char2Num = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (char2Num.containsKey(ch)) {
                char2Num.put(ch, char2Num.get(ch) + 1);
            } else {
                char2Num.put(ch, 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            Character ch = t.charAt(j);
            if (!char2Num.containsKey(ch)) {
                return false;
            } else {
                int remainNum = char2Num.get(ch) - 1;

                if (remainNum == 0) {
                    char2Num.remove(ch);
                } else {
                    char2Num.put(ch, remainNum);
                }
            }

        }
        return char2Num.isEmpty();
    }

}
