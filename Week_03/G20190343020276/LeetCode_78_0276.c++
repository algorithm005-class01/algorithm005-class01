class Solution {

private:
    void subsets(vector<vector<int> > &results,vector<int>& nums,vector<int> &result,int index)
    {
        //terminator
        if(index == nums.size())
        {
            results.push_back(result);
            return;
        }
        //process logic in current level 
        //drill down
        subsets(results,nums,result,index + 1);

        result.push_back(nums[index]);
        subsets(results,nums,result,index + 1);

        //reverse state
        result.pop_back();

        // results.push_back(result);
        // for (int j = index; j < nums.size(); j++) {
        //     result.push_back(nums[j]);
        //     subsets(results,nums,result,j + 1);
        //     result.pop_back();
        // }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int> >results;
        vector<int> result;
        subsets(results,nums,result,0);
        return results;
    }
};
