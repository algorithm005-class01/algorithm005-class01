package week01;

public class Leetcode_88_0230 {

    //  输入:
    // nums1 = [1,2,3,0,0,0], m = 3
    // nums2 = [2,5,6],       n = 3
    //
    // 输出: [1,2,2,3,5,6]

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        // 从源数组第0个元素拷贝到目标数组
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // nums1_copy的指针
        int p1 = 0;
        // nums2的指针
        int p2 = 0;
        // nums1的指针
        int p = 0;

        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

//        while ((p1 < m) && (p2 < n)) {
//            if (nums1_copy[p1] < nums2[p2]) {
//                nums1[p] = nums1_copy[p1];
//                p1++;
//            } else {
//                nums1[p] = nums2[p2];
//                p2++;
//            }
//            p++;
//        }

        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        Leetcode_88_0230 test = new Leetcode_88_0230();
        test.merge(nums1, 3, nums2, 3);
    }
}
