package G20190343020064;

import org.junit.Test;

/**
 * <p>
 * 反转字符串 II
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-16 9:48 下午
 */
public class LeetCode_541_0064 {

    /**
     * 待修改
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int len = 2 * k;
        int index = s.length() / len;
        int res = s.length() & len;
        char[] chars = new char[s.length()];
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < k; j++) {
                chars[(i + 1) * len - 1 - k - j] = s.charAt(i * len + j);
            }
            for (int j = i * len + k; j < (i + 1) * len; j++) {
                chars[j] = s.charAt(j);
            }
        }
        for (int i = index * len, j = 0; i < s.length(); i++, j++) {
            if (res > k && j > k) {
                chars[i] = s.charAt(i);
            } else {
                chars[s.length() - (res - k) - 1 - j] = s.charAt(i);
            }
        }
        return new String(chars);
    }

}
