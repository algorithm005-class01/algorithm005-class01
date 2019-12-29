package week02;

public class Leetcode_242_0230 {

    // 方法1：时间复杂度O(nlogn)
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1, str2);
//    }

    // 方法2：哈希映射
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (alpha[i] != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Leetcode_242_0230 solution = new Leetcode_242_0230();
        System.out.println(solution.isAnagram(s, t));
    }

}