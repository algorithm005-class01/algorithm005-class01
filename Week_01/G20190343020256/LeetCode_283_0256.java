package Week0;

public class LeetCode_283_0256 {
    /**
     * 双指针，交换值
     * 时间复杂度 0(n)
     */
    public void moveZeroesByTwoPointers(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[i] == 0 ) {
                zero++;

            } else  {
                int targetPoint = i - zero;
                int temp = nums[i];
                nums[i] = nums[targetPoint];
                nums[targetPoint] = temp;

            }
        }
    }

    /**
     * 双指针，直接将非0的数 cover 掉为0的值，再将后面的值一起设置为0
     * 对我自己来说，这个思路先理解了再去理解上面的交换会容易一些
     */
    public void moveZeroesByCoverZero(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
