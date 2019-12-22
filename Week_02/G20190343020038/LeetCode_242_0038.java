import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    //先排序，再比较两个数组。O(nlogn)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {//判断长度是否一致
            return false;
        }
        //字符串转数组
        char[] str1 = s.toCharArray();//字符串转数组用str.toCharArray()
        char[] str2 = t.toCharArray();
        //数组排序，排序成本O(nlogn)
        Arrays.sort(str1);//数组排序用Arrays.sort()
        Arrays.sort(str2);
        //比较两个数组是否一样
        return Arrays.equals(str1, str2);//数组相等比较用Arrays.equal()
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];//counter数组存每个字母出现的次数
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;//使用s.charAt(i)-'a'来标记当前s中的字母
            counter[t.charAt(i) - 'a']--;//同时减去在t中出现的字母
        }

        for (int count: counter) {//都跑完了，来检查counter中有没有出现非零。
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];//counter数组存每个字母出现的次数
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i)-'a']++;
        }
        for (int i=0; i<t.length(); i++) {
            counter[t.charAt(i)-'a']--;
            if (counter[t.charAt(i)-'a'] < 0) { //一旦发现有一个字母出现的次数是负数，表示当前的字母不存在于s中。
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

