package week01;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 两数之和.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_1_0314 {
  public int[] twoSum(int[] nums, int target) {
    Map tempMap = new HashMap<Integer, Integer>();
    int temp = target-nums[0];
    tempMap.put(temp,0);
    for(int i=1; i<nums.length; i++){
      if(tempMap.containsKey(nums[i])) return new int[]{(int)tempMap.get(nums[i]),i};
      temp = target-nums[i];
      tempMap.put(temp,i);
    }
    return null;
  }
}
