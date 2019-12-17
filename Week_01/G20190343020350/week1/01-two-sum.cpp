class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash;
        for(int i = 0; i < nums.size(); i++){
        	if(hash.count(target - nums[i])) 
				return {hash[target - nums[i]], i};
        	hash[nums[i]] = i;
		}
		return {-1, -1};
    }
};