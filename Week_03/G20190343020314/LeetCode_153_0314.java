package week03;

/**
 * Description: 寻找旋转排序数组中的最小值.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_153_0314 {
  public int findMin(int[] nums) {
    
    int leftIndex=0;
    int rightIndex=nums.length-1;
    int minValue=nums[0];
    
    while(leftIndex<=rightIndex) {
      int middleIndex=leftIndex+(rightIndex-leftIndex)/2;
      if(leftIndex==middleIndex) {
        if(nums[leftIndex]>nums[rightIndex]) {
          minValue = nums[rightIndex]<minValue ? nums[rightIndex] : minValue;
        } else {
          minValue = nums[leftIndex]<minValue ? nums[leftIndex] : minValue;
        }
        break;
      }
      if(nums[leftIndex]>nums[middleIndex]) {
        rightIndex=middleIndex;
      } else {
        if(nums[middleIndex]>nums[rightIndex]) {
          leftIndex=middleIndex;
        } else {
          rightIndex=middleIndex;
        }
      }
    }
    return minValue;
  }
}
