package com.example.demo;

public class Test_0084_Week01 {

    //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int currentIndex=0;
        for(int i=1;i<nums.length;i++){//i为第二个指针 一直往后走，寻找与当前val不同的值，并放到currentIndex后面，currentIndex则向后移动一位
            int currentVal=nums[currentIndex];
            int findVal=nums[i];
            if(findVal!=currentVal){
                nums[currentIndex+1]=findVal;
                currentIndex++;
            }
        }
        return currentIndex+1;
    }
    //https://leetcode-cn.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            int val= digits[i]%10;
            if(val!=0){return digits;}else{digits[i]=0;}
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }


    //https://leetcode-cn.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;
        while(p1>=0&&p2>=0){
            nums1[p--]=nums1[p1]>nums2[p2]?nums1[p1--]:nums2[p2--];
        }
        if(p2>=0){
            System.arraycopy(nums2,0,nums1,0,p2+1);
        }
    }


    //https://leetcode-cn.com/problems/merge-two-sorted-lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode  node=new ListNode(-1);
        ListNode tail=node;

        while(l1!=null&&l2!=null){
            if(l1.val>=l2.val){
                tail.next=l2;
                l2=l2.next;
            }else{
                tail.next=l1;
                l1=l1.next;
            }

            tail=tail.next;

        }

        tail.next= l1==null?l2:l1;

        return node.next;
    }

    //https://leetcode-cn.com/problems/rotate-array/
    // 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    // 要求使用空间复杂度为 O(1) 的 原地 算法。
    public void rotate(int[] nums, int k) {
        //不考虑额外使用数组的方法
        //空间复杂度O(1)暴力法
        // k=k%nums.length;
        // for(int j=0;j<k;j++){
        //     int cur=nums[nums.length-1];
        //     for(int i=0;i<nums.length-1;i++){
        //        nums[nums.length-1-i]=nums[nums.length-i-1-1];
        //     }
        //     nums[0]=cur;
        // }


        //方法 直接把数字放到最终位置
        //12 34567 89

        // k=k%nums.length;
        // // if(k==0){return;}
        // int count=0;
        // for(int start=0;count<nums.length;start++){
        //     int currentVal=nums[start];
        //     int currentIndex=start;
        //     do{
        //         int nextIndex=(currentIndex+k)%nums.length;
        //         int tmp=nums[nextIndex];
        //         nums[nextIndex]=currentVal;
        //         currentVal=tmp;
        //         count++;
        //         currentIndex=nextIndex;
        //     }while(currentIndex!=start);
        // }

        //反转方法
        //12 34567 89
        //98 76543 21
        //89 12345 67
        k=k%nums.length;
        if(k==0){return;}
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    public void reverse(int start,int end,int[] nums){
        for(int i=start;i<(end+start)/2+1;i++){
            int tmp=nums[i];
            nums[i]=  nums[end+start-i];
            nums[end+start-i]=tmp;
        }
    }

}
