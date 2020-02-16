package G20190343020064;

/**
 * <p>
 * 字符串中的第一个唯一字符
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-16 8:20 下午
 */
public class LeetCode_387_0064 {


    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
