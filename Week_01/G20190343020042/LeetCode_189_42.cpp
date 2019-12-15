class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int len = nums.size();
        if(len==k)
            return;
        if(k>len)
            k = k%len;
        int iTemp[len+1];
        for(int i=0;i<k;i++)
        {
            iTemp[i] = nums[len-k+i];
        }
        for(int j=0;j<len-k;j++)
        {
            iTemp[k+j] = nums[j];
        }
       
        nums.clear();
        std::copy(iTemp,iTemp+len, std::back_inserter(nums)); 
    }
};