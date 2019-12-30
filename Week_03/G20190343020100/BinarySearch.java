package com.algorithm.week03;

public class BinarySearch {

    //右中位 无符号位移方式
    public int search2(int[] nums,int target) {
        int len = nums.length;

        int left = 0,right = len - 1;

        while (left < right) {
            //右中位
          int mid = (left + right + 1) >>> 1;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target)
            return left;

        return -1;
    }

    //标准二分
    public int search(int[] nums,int target) {
        int len = nums.length;

        int left = 0,right = len - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(new int[]{1,3,7,9,11,28,31},3));

        System.out.println( (0 + 8) >>> 1);

    }
}
