package G20190343020064;

import java.util.Arrays;

/**
 * <p>
 * 有效的字母异位词
 * </p>
 *
 * @author mingke
 */
public class LeetCode_242_0064 {


    /**
     * 先将字符串排序，然后对比是否一样
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        ///===============================================================================
        //  记录26个字母出现的次数
        //===============================================================================
        int[] counter = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //  依次将 s 中出现的字符对应counter的下标 +1
            counter[s.charAt(i) - 'a'] ++;
            //  将 t 中出现的字符，在对应中出现的字符对应counter的下标的下标 -1
            counter[t.charAt(i) - 'a'] --;
        }
        //===============================================================================
        //  如果为异位词， 则counter中所有的数据都应该为0 如果不为0则不是
        //===============================================================================
        for(int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
