class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        //遍历
        for (int i = 0 ; i < nums.size(); i ++){
            for (int j = i+1; j < nums.size() ; j ++){
                if (nums[i] == nums[j]){
                    nums.erase(nums.begin()+j);
                    j = j-1;
                }
            }
        }
        return nums.size();
    }
};
