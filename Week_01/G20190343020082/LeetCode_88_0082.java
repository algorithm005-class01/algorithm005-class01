public class LeetCode_88_0082 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2= n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p1 + p2] = nums1[p1] > nums2[p2] ? nums1[p1 --] : nums2[p2 --];
        }
        while (p2 >= 0) nums1[p2] = nums2[p2 --];
    }

    public static void main(String[] args) {
        new LeetCode_88_0082().merge(new int[1], 0, new int[] {1}, 1);
    }

}
