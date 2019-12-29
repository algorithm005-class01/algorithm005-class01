
class Solution {
    // 01 排序 比较 时间复杂度 O(NKlogK)
    
    // public boolean isAnagram(String s, String t) {
    // if (s.length() != t.length()) return false;
    // //转换成字符数组
    // char[] str1 = s.toCharArray();
    // char[] str2 = t.toCharArray();
    // //排序
    // Arrays.sort(str1);
    // Arrays.sort(str2);
    // //比较
    // return Arrays.equals(str1, str2);

    // }
    // 02 hash表 时间复杂度 O(n)

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map map = new HashMap();
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;

    }
}