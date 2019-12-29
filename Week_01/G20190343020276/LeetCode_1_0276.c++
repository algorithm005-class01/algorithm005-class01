class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        // for(int i=0;i<nums.size();i++)
        // {
        //     for(int j=i+1;j<nums.size();j++)
        //     {
        //         if(nums[i] + nums[j] == target)
        //         {
        //             return vector<int>{i,j};
        //         }
        //     }
        // }

        //建立一张哈希表key是vecotor中的元素，值是对应元素的索引
        std::unordered_map<int,int> hashMap;

        for(int i = 0;i<nums.size();i++)
        {   
            hashMap.insert(std::make_pair(nums[i],i));
        }
        for(int i=0;i<nums.size();i++)
        {
            int diff = target - nums[i];
            
            if(hashMap.find(diff) != hashMap.end() && hashMap.at(diff) != i)
            {
                return vector<int>{i,hashMap.at(diff)};
            }
        }
        return {0,0};
    }
};