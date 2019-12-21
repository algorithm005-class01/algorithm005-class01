// input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3
// Output: [1,2,2,3,5,6]
// 题目描述：把归并结果存到第一个数组上。

//思路： 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
/*
 思路: 目标是将nums2中的有序数组内容merge到nums1的有序数组中。
为了让nums2中被拿出来的数字不污染 nums1中原有的成员，所以选择从最后尾巴的元素开始考察，
考察完成后将得到的值存到nums1里位于merge完成后的最大位置： nums1[m+n-1]的位置上 
  */
 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, index3 = m + n - 1;
        while (index1 >= 0 && index2 >= 0){
            if (nums1[index1] > nums2[index2]){
                nums1[index3--] = nums1[index1--]; //存到结果数组的最高位去，自身减一，往前一步走
            } else {
                nums1[index3--] = nums2[index2--]; 
            }
        }
        while(index2 >= 0) {//这里index1<0,说明nums1的待排部分已经完成，而nums2还有没考察完的，所以index2是大于0的. 如果是index2<0，说明已经排好了。
            nums1[index3--] = nums2[index2--];
        }
    }
}
