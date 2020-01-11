/**
 暴力法：还原，从头到尾遍历， 二分查找
 正解：二分查找
 a 单调
 b 有界
 c
 **/
class LeetCode_33_0120 {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int low =0;int high = nums.length-1;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            //这是代表左半部分是有序，升序排列
            if(nums[low]<=nums[mid]){
                if(target>=nums[low]&&target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid + 1;
                }


            }else{
                //这是代表右半部有序
                if(nums[mid]<target&&target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}