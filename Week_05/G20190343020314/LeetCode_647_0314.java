package week05;

/**
 * Description: 回文子串.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_647_0314 {
  public int countSubstrings(String s) {
    int res = 0;
    boolean dp[][] = new boolean[s.length()][s.length()];
    for (int j = 0; j < s.length(); j++) {
      for (int i = j; i >= 0; i--) {
        if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          res++;
        }
      }
    }
    return res;
  }
}
