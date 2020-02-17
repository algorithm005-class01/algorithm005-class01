package main.leetcode_solutions.character;

/**
 * @author wenzhuang
 * @date 2020/2/16 10:17 PM
 */
public class T387_FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
