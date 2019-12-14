package leetcode_283_0220;


/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
*/

/**
 * @author Darcy
 * @date 2019-12-11 09:30
 */
public class Sulotion {
    public void moveZeroes(int[] nums) {
        /*记录0的位置*/
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != 0) {
                j++;
                continue;
            }
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                nums[i] = 0;
            }
        }

    }
}
