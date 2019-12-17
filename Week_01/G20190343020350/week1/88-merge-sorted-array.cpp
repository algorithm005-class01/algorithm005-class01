class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        
        if(m == 0) 
        {
            swap(nums1,nums2);
            return;
        }

        int ptr = m - 1;
        int ptr1 = n -1;

        int p = m + n -1;

        while (ptr >= 0 && ptr1 >= 0) {

            nums1[p--] = (nums1[ptr] < nums2[ptr1]) ? nums2[ptr1--] : nums1[ptr--];

        }
        while (ptr1 >= 0)
            nums1[p--] = nums2[ptr1--];

    }
};