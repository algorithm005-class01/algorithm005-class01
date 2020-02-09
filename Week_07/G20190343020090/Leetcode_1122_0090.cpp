class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> result;
        int counter[1001] = {0}; 
        for (auto it = arr1.begin(); it != arr1.end(); ++it)
        {
            counter[*it] ++;
        }
        for (auto it = arr2.begin(); it != arr2.end(); ++it)
        {
            for (auto i=0; i < counter[*it]; ++i){
                result.push_back(*it);
            }
            counter[*it] = 0;
        }
        for (auto i = 0; i < 1001; ++i)
        {
            if (counter[i] != 0){
                for (auto j=0; j < counter[i]; ++j){
                    result.push_back(i);
                }
            }
        }
        return result;
    }
};