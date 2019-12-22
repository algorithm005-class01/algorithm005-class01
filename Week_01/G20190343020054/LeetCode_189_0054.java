public class LeetCode_189_0054 {

    /**
     * 189. 旋转数组
     */

    /**
     * 1. 暴力破解
     *
     * 旋转 k 次，每次将数组旋转 1 个元素。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n*k) 。
     * 空间复杂度：O(1)，没有使用额外的空间
     */
    public void rotate(int[] nums, int k) {
        // 暴力解法
        int temp, previous;
        // 旋转 k 次
        for (int i = 0; i < k; i++) {
            // 获取当前旋转
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 2. 使用额外的数组
     *
     * 使用额外的一个数组存储正确的元素，然后再将它 copy 到数组中。
     *
     * 复杂度分析：
     *
     * 时间复杂度： O(n)。
     * 空间复杂度： O(n)。另一个数组需要原数组长度的空间。
     */
    public void rotate2(int[] nums, int k) {
        int[] copy =  new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 当前值 + k 对长度取余
            // nums = [1,2,3,4,5,6,7] k = 3
            // copy[[0 + 3] % 7] = copy[3] = 1
            // copy[[1 + 3] % 7] = copy[4] = 2
            // copy[[2 + 3] % 7] = copy[5] = 3
            // copy[[3 + 3] % 7] = copy[6] = 4
            // copy[[4 + 3] % 7] = copy[0] = 5
            // copy[[5 + 3] % 7] = copy[1] = 6
            // copy[[6 + 3] % 7] = copy[2] = 7
            copy[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < copy.length; i++) {
            nums[i] = copy[i];
        }
    }

    /**
     * 3. 反转
     *
     * 当我们旋转数组 k 次，k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     *
     * 我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
     *
     * ```
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * ```
     *
     * 时间复杂度
     *
     * 时间复杂度：O(n)。 n 个元素被反转了总共 k 次。
     *
     * 空间复杂度：O(1)。 没有使用额外的空间。
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        // 反转全部
        reverses(nums, 0, nums.length - 1);
        // 反转前 k 个
        reverses(nums, 0, k - 1);
        // 反转 k 后的元素
        reverses(nums, k, nums.length - 1);
    }

    private void reverses(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 4. 使用环状替换（暂时没完全懂）
     */
    public void rotate4(int[] nums, int k) {
        // 定义一个 count 变量用来计数
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            // 当前的指针位置
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while(start != current);
        }
    }
}