package main.leetcode_solutions.hashtable;

/**
 * @author wenzhuang
 * @date 2019/12/20 11:09 PM
 */
public class T242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
