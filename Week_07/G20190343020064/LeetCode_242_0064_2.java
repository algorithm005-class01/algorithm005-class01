package G20190343020064;

/**
 * <p>
 * 有效的字母异位词
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-09 10:38 下午
 */
public class LeetCode_242_0064_2 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for(int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
