class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hashmap;
        for (int i = 0; i < nums.size(); i++)
        {
            if (hashmap.count(target - nums[i]))
                return {i, hashmap[target - nums[i]]};
            else
                hashmap[nums[i]] = i;
        }
        return {0, 0};
    }
};