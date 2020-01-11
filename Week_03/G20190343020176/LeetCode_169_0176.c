int   rangnumsize(int *nums,int num,int lo,int hi)
{
    int count = 0;
    for(int i=lo;i<=hi;i++)
    {
        if(nums[i] == num)
        {
            count++;
        }
    }
    return count;
}

int majorityElementdate(int* nums,int lo,int hi)
{
    if(lo == hi)
    {
        return nums[lo];
    }
    int mid=lo+(hi - lo)/2;
    int left = majorityElementdate(nums,lo,mid);
    int right = majorityElementdate(nums,mid+1,hi);

    if(left == right)
    {
        return left;
    }

    int leftcount = rangnumsize(nums,left,lo,hi);
    int rightcount = rangnumsize(nums,right,lo,hi);   

    return leftcount>rightcount ? left:right;
}
int majorityElement(int* nums, int numsSize){
    return     majorityElementdate(nums,0,numsSize-1);
}