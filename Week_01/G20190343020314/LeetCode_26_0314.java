package week01;

/**
 * Description: 删除排序数组中的重复项
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_26_0314 {
  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        nums[++i] = nums[j];
      }
    }
    return i+1;
  }
}
