package com.log8;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(null==nums1) {
            return;
        }
        if(null==nums2) {
            return;
        }
        int i=m-1;
        int j=n-1;
        int all=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[all]=nums1[i];
                all--;
                i--;
            }else{
                nums1[all]=nums2[j];
                all--;
                j--;
            }
        }
        if(j>=0){
            while(j>=0){
                nums1[all]=nums2[j];
                all--;
                j--;
            }
        }
    }


    /**
     * 2019-12-13 19:54
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums1==null||nums2==null) {
            return;
        }
        m = m - 1;
        n = n - 1 ;
        int length = nums1.length-1;
        while(m >= 0 && n >= 0){
            if(nums1[m]>nums2[n]){
                nums1[length--] = nums1[m--];
            }else{
                nums1[length--] = nums2[n--];
            }
        }
        while (n > 0) {
            nums1[n]= nums2[n--];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,0,0,0};
        int[] nums2 = new int[]{2,4,8};
        int m = 3;
        int n = 3;
        Solution88  ss = new Solution88();
//        ss.merge(nums1,m,nums2,n);
        ss.merge2(nums1,m,nums2,n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(i + "---" + nums1[i]);
        }
    }
}













