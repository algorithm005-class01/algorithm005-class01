package week06;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 爬楼梯.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_70_0314 {
  class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
      
      if(n==1 || n==0){
        return 1;
      }
      if(n==2) return 2;
      if(n==3) return 3;
      
      if(map.get(n-1) == null) {
        map.put(n-1, climbStairs(n-1));
      }
      if(map.get(n-2) == null) {
        map.put(n-2, climbStairs(n-2));
      }
      
      return map.get(n-1)+map.get(n-2);
      
    }
  }
}
