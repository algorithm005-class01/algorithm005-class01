package week07;

/**
 * Description: 位1的个数.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_191_0314 {
  public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
      int sum = 0;
      while (n != 0) {
        sum++;
        n &= (n - 1);
      }
      return sum;
    }
  }
}
