package week03;

/**
 * Description: 多数元素.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_169_0314 {
  public int majorityElement(int[] nums) {
    return majorityElement(nums, 0, nums.length-1);
  }
  
  private int majorityElement(int[] nums, int lo, int hi) {
    if(lo==hi){
      return nums[lo];
    }
    
    int mid = (hi-lo)/2 + lo;
    int left = majorityElement(nums, lo, mid);
    int right = majorityElement(nums, mid+1, hi);
    
    int leftCount = 0;
    int rightCount = 0;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] == left) {
        leftCount++;
      }
      if (nums[i] == right) {
        rightCount++;
      }
    }
    
    return leftCount>rightCount ? left : right;
  }
}
