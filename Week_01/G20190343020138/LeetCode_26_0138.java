package com.log8;

public class Solution26 {
    //first
    public int removeDuplicates(int[] nums) {
        if (null==nums) {
            return 0;
        }
        int i = 0;
        for (int j=1;j<nums.length;j++) {
            if(nums[i]!=nums[j]){
//                i++;
//                nums[i]=nums[j];
                //此处也可以使用上面的两行代码 但是这行代码比较简洁
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }

    //2019-12-13
    public int removeDuplicates2(int[] nums){
        if(nums==null){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                int tmp=nums[i++];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2};
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution26 s26 = new Solution26();
        int result = s26.removeDuplicates(nums);
//        int result = s26.removeDuplicates2(nums);
        System.out.println(result);
        for(int i=0;i<result;i++){
            System.out.println(i +"--" +nums[i]);
        }

    }
}
