void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){

    int i = 0 ,j = n-1,x = m -1;
    i = m+n-1;
    while(j>=0&&x>=0)
    {
        if(nums2[j]>nums1[x])
        {
           nums1[i] = nums2[j];
           j--;
        }
        else
        {
            nums1[i] = nums1[x];
            x--;
        }
        i--;
    }

    while(j>=0)
    {
       nums1[i--] = nums2[j--]; 
    }
}