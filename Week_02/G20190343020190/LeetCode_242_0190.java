import java.util.HashMap;
import java.util.Map;

public class LeetCode_242_0190 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int[] letterArray = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            letterArray[chars1[i] - 'a']++;
            letterArray[chars2[i] - 'a']--;
        }

        for (int i : letterArray) {
            if (i != 0) return false;
        }
        return true;
    }
}
