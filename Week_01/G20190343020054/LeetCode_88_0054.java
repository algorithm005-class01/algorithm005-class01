import java.util.Arrays;

public class LeetCode_88_0054 {

    /**
     * 88. 合并两个有序数组
     */

    /**
     * 1. 先合并后排序
     * <p>
     * 由于 nums1 有足够的空间，因此，用一个 for 循环将 nums2 的元素添加到 nums1 中，然后调用 sort 排序即可。
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 可以直接使用 arraycopy 复制
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    /**
     * 2. 双指针 / 从前往后
     * <p>
     * 对于有序数组可以通过 双指针法 达到 `O(n + m)` 的时间复杂度。
     * <p>
     * 最直接的算法实现是将指针 `p1` 置为 `nums1` 的开头， `p2`为 `nums2` 的开头，在每一步将最小值放入输出数组中。
     * <p>
     * 由于 `nums1` 是用于输出的数组，需要将`nums1`中的前`m`个元素放在其他地方，也就需要 `O(m)` 的空间复杂度。
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 创建一个 nums1 的 copy 数组
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        // 定义 nums1,nums1_copy, nums2 的指针
        int p = 0, p1 = 0, p2 = 0;
        // 比较 nums1_copy 和 nums2 中的元素
        // 并将最小的一个添加到 nums1 中。
        while (p1 < m && p2 < n)
            nums1[p++] = nums1_copy[p1] > nums2[p2] ? nums2[p2++] : nums1_copy[p1++];

        //如果 nums1 与 nums2 的元素个数不同，有剩余元素
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    /**
     * 3. 双指针/ 从后往前
     * <p>
     * 方法二已经取得了最优的时间复杂度 O(n + m)，但需要使用额外空间。这是由于在从头改变 nums1 的值时，需要把 nums1 中的元素存放在其他位置。
     * <p>
     * 如果从结尾开始遍历呢？
     * <p>
     * 因为 nums1 有足够的空间，因此不需要使用额外的空间。
     * <p>
     * 定义三个指针，p -> nums.length-1，p1 -> nums1[m-1]，p2 -> nums2[n-1]。
     * <p>
     * 每次判断 p1，p2 的大小，大的放入 p 的位置，然后移动 p 与 (p1,p2较大值) 的指针。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 创建一个 nums1 的 copy 数组
        int p = nums1.length - 1, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0)
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];

        // 如果 p2 < 0 退出了，就表示 nums1 的元素比 nums2 的元素多，说明，nums2 的元素都已经添加完毕了
        // 如果 p1 < 0 退出了，就表示 nums1 的元素比 nums2 的元素少，
        // nums2 的元素要加到 nums1 的开头
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}