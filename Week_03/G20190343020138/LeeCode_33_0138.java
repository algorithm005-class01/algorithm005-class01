package com.log8.week03;

/**
 * 使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
 * 说明：同学们可以将自己的思路、代码写在学习总结中
 */
public class Homew {

    public int solution(int[] nums){
        if(nums==null){
            return -1;
        }
        //check null
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<high&&low+1<high){
            mid = (high+low)/2;
            if(nums[mid]>=nums[low]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
//        System.out.println((4 + 5) / 2);
        int[] nums = new int[]{4,5,6,7,0,1,2};
        Homew tt = new Homew();
        System.out.println(tt.solution(nums));
    }

}
