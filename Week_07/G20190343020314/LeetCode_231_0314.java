package week07;

/**
 * Description: 2的幂.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_231_0314 {
  class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n == 0) return false;
      long x = (long) n;
      return (x & (-x)) == x;
    }
  }
}
