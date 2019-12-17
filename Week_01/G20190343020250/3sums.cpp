#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        // if(nums.size()<3)
        //     return false;
        if(nums.size()<3)
            return result;
   
        int k=0,i=1,j=nums.size()-1,resultcnt=0;
        int Size=nums.size()-2;
        sort(nums.begin(),nums.end());
        //while(k < nums.size())        //少写这种不安全的循环条件，一定不要忽视标的的迭代
        for(k = 0 ; k < Size ; k++)
        {
            if(nums[k]>0)
                break;
            int tempk =nums[k];
            int tempknegative = 0 - nums[k];
            i = k+1;
            while(i < j)
            {
                int templow = nums[i];
                int temphigh = nums[j];
                int tempsum = nums[i]+nums[j] ;
                if(tempsum == tempknegative)
                {
                    //vector<int> tmpVec{nums[k],nums[i],nums[j]};
                    vector<int> tmpVec{tempk,templow,temphigh};
                    result.push_back(tmpVec);  
                   // k++;
                    while(j>i && nums[j]==temphigh) j--;
                    while(j>i && nums[i]==templow) i++;
                }
                else if(tempsum < tempknegative)
                {   
                    ++i;
                    //while(j>i && nums[j]!=nums[--j]);
                }
                else --j; //while(j>i && nums[i]!=nums[++i]);
            }
            while(k + 1 < Size && nums[k]==nums[k+1])
                k++;
        }
        return result;
    }
};