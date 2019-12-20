package G20190343020018;

import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @program: leetcode->P0283_MoveZeros
 * @description: 移动0至末尾
 * @author: wangbo4
 * @create: 2019-12-11 13:48
 **/
public class LeetCode_283_0018 {
    public static void main(String[] args) {

        //测试用例
        int[] arrays = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        moveZeroes(arrays);
        System.out.println(Arrays.toString(arrays));


        arrays = new int[]{2, 1};
        moveZeroes(arrays);
        System.out.println(Arrays.toString(arrays));

        arrays = new int[]{0, 0, 3, 2, 5, 4, 3, 0, 0, 0, 484, 2, 5, 0};
        moveZeroes(arrays);
        System.out.println(Arrays.toString(arrays));

        arrays = new int[]{1, 0, 0, 0, 0, 0, 0};
        moveZeroes(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    /**
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //swap 交换所需临时变量
        int tmp = -1;
        //循环过程中，遇到0的个数。
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素不是0，需要往前移动。
            if (nums[i] != 0) {
                //防止第一个元素为0，往前移动 角标越界。
                if (i != 0) {
                    tmp = nums[i - count];
                    nums[i - count] = nums[i];
                    nums[i] = tmp;
                }
            } else {
                count++;
            }
        }
    }

}
