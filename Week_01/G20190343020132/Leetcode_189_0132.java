package org.azai.train.Week01;
//1.开辟一个新数组，将元素放到对应的位置，再将nums的引用指向新数组
//2.三次反转
public class Leetcode_189_0132 {
    public void rotate(int[] nums, int k) {
        if (nums==null||nums.length==0) return;
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k%nums.length-1);
        reserve(nums,k%nums.length,nums.length-1);
    }
    public void reserve(int[] nums,int left,int right) {
        while (left < right) {
            nums[left] = nums[left]^nums[right];
            nums[right] = nums[left]^nums[right];
            nums[left] = nums[left]^nums[right];
            left++;
            right--;
        }
    }
}
