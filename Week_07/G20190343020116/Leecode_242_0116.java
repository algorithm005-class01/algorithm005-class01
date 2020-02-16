import java.util.HashMap;
import java.util.Map;

/**
 * 字母异位词
 *
 * 字符串排序。比较两个数组是否相同。
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return  false;
        }

        char[] charsA = s.toCharArray();
        char[] charsB = t.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);

        return Arrays.equals(charsA,charsB);
    }
}
