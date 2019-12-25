#include <iostream>
#include <vector>
using namespace std;


//没什么好说的，最基本的递归
class Solution {
public:
    
    void proccess(vector<int>& nums,int cur,vector<vector<int>>& resv)
    {
        if(cur==nums.size()){
            resv.push_back(nums);
            return;
        }
        for(int i=cur;i<nums.size();++i){
            swap(nums[cur],nums[i]);
            proccess(nums,cur+1,resv);
            swap(nums[cur],nums[i]);
        }
    }
    
    vector<vector<int>> permute(vector<int>& nums) {
        if(nums.size()==0)
            return {};
        vector<vector<int>> resv;
        proccess(nums,0,resv);
        return resv;
    }
};

int main()
{

}
