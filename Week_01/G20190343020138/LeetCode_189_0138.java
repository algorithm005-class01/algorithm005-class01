package com.log8.week01;

public class Solution189 {

    //solution 1

    /**
     *
     * @param nums 数组
     * @param k 右移位数
     */
    public void rotate(int[] nums,int k){
        if(nums==null||nums.length==0||k==0){
            return;
        }
        int realK = k%nums.length;
        //全部旋转
        rotateArray(nums,0,nums.length-1);
        //旋转前K个
        rotateArray(nums,0,realK-1);
        //旋转k到length-1个
        rotateArray(nums,realK,nums.length-1);
    }

    public void rotateArray(int[] nums,int start,int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    //solution 2
    public void rotate2(int nums[],int k){
        if(null==nums||nums.length==0||k==0){
            return;
        }
        int realK = k%nums.length;
        int start, count = 0;
        for (start=0;count < nums.length;start++){
            int next = start;
            int prev = nums[start];

            do{
                next = (next+realK)%nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                count ++;
            }while (next!=start);


        }

    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,-100,3,99};
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Solution189 test = new Solution189();
        test.rotate(nums,3);
//        test.rotate(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + "----" + nums[i]);
        }
    }
}
