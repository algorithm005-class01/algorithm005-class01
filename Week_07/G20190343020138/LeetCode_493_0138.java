package com.log8.week07;

import java.util.Arrays;

public class Solution493 {
    //
    public int res;
    //使用归并的思路解决问题
    public int reversePairs(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        //注意此处是length-1 因为需要遍历下标 所以组要传入nums.length-1
        solve(nums,0,nums.length-1);

        return res;
    }

    public void solve(int[] nums,int left,int right){
        if(left>=right) return;
        int mid = (left+right)>>1;
        solve(nums,left,mid);
        solve(nums,mid+1,right);
        int count = 0;
        //合并
        for(int i=left,j=mid+1;i<=mid;){
            if(j>right || nums[i]/2.0<= nums[j]){
                i++;
                res = res + count;
            }else{
                j++;
                count++;
            }
        }
        Arrays.sort(nums,left,right+1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        Solution493 s493 = new Solution493();
        System.out.println(s493.reversePairs(nums));
    }
}
