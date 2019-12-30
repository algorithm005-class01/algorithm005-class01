class Solution {
    public int majorityElement(int[] nums) {
        int countFlag=0;
        int result = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(countFlag==0){
                result=nums[i];
            }
            countFlag+=(result==nums[i])?1:-1;
        }
        return result;
    }
}
