package week08;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 字符串中的第一个唯一字符.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_387_0314 {
  class Solution {
    public int firstUniqChar(String s) {
      int result=-1;
      Map<Character, Integer> map = new HashMap<>();
      int length = s.length();
      for(int i=0; i<length; i++) {
        char c = s.charAt(i);
        Integer count = map.get(c);
        if(count==null){
          map.put(c,1);
        } else {
          map.put(c,count+1);
        }
      }
      
      for(int i=0; i<length; i++) {
        int count2 = (Integer) map.get(s.charAt(i));
        if(count2==1) return i;
      }
      
      
      return result;
    }
  }
}
