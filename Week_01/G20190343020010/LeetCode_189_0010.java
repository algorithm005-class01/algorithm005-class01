
/**
 * xiezhilin
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_189_0010 {

    public void rotate(int[] nums, int k) {
        int remainder = k > nums.length ? (k % nums.length) : k;

        for (int i = 0; i < remainder; i++) {
            int last = nums[nums.length - 1];

            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = last;
                last = temp;
            }
        }
    }
}
