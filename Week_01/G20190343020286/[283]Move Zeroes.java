//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 移动零
 */
class Solution {
    /**
     * 方法一：i指针遍历数组，j指向非0要插入的位置
     * @param nums
     */
    /*public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }*/


    /**
     * 方法二：i指针遍历数组，j指向非0，非0与0交换位置
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
