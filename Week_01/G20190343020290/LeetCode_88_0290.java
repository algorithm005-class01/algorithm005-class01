/**
 * Created by Ju·Felix on 2019/12/15.
 */
public class LeetCode_88_0290 {
    public static void main( String[] args ) {
        int[] nums1 = new int[]{3, 6, 8, 9, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 5};

        int[] result = merge(nums1, 4, nums2, 3);

        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    /**
     * 88. Merge Sorted Array [easy]
     * @param nums1 [3, 6, 8, 9, 0, 0, 0]
     * @param m 4
     * @param nums2 [2, 3, 5]
     * @param n 3
     * --> [2, 3, 3, 5, 6, 8, 9]
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // 在一层循环中通过手动控制i和j，避免了System.arrayCopy这种java耗时操作
        for(int i = m - 1, j = n - 1, flag = nums1.length - 1; (i >= 0 || j >= 0) && flag >= 0; --flag) {
            int n1 = i < 0 ? Integer.MIN_VALUE : nums1[i];
            int n2 = j < 0 ? Integer.MIN_VALUE : nums2[j];
            if (n1 >= n2) {
                nums1[flag] = n1;
                --i;
            } else {
                nums1[flag] = n2;
                --j;
            }
        }
        return nums1;
    }
}
