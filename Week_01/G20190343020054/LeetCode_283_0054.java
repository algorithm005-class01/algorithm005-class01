public class LeetCode_283_0054 {

    /**
     * 283. 移动零
     */

    // 方法 1 暴力破解
    // 定义一个计数变量，使用两个 for 循环实现移动
    // 第一个 for 循环中只进行元素的赋值，比如[0,1,2,0,3] - for - > [1,2,3,0,3]，
    // 赋值完成后，count 指向 index = 2 的元素 3;
    // 第二个 for 循环将 count 后续的元素值改为零
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
    }


    // 方法 2
    // 一层 for 循环，当 i != 0 时，进行元素的交换赋值
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[count];
                nums[count++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    // 方法三
    // 对方法 2 的一个优化，加入了 index 与 count 不一致时，在进行数据的交换。
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }

}