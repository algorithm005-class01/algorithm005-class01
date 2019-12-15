void rotate(int* nums, int numsSize, int k){
   int i = 0,temp = 0,j = 0,n = k%numsSize,currt = 0,prev = 0,next = 0;
   for(i=0;j<numsSize;i++)
   {
       currt = i;
       prev = nums[i];
        do
       {
           next = (currt+n)%numsSize;
           temp = nums[next];
           nums[next] = prev;
           prev =  temp;
           j++;
           currt = next;

       } while(i != currt);
   }
}