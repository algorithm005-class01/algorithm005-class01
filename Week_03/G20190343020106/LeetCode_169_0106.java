package week03;

class Solution {
    public int majorityElement(int[] nums) {
        assert (nums.length > 0);

        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int left, int right) {

        int len = right - left + 1;
        if (len <= 2) {
            assert (len >= 1);
            return nums[left];
        }

        int mid = (left + right) / 2;
        int leftMajority = majorityElement(nums, left, mid);
        int rightMajority = majorityElement(nums, mid + 1, right);

        if (leftMajority == rightMajority)
            return leftMajority;

        int leftMajorityCnt = occurance(nums, left, mid, leftMajority);
        int rightMajorityCnt = occurance(nums, mid + 1, right, rightMajority);

        assert (leftMajority != rightMajority);
        return leftMajorityCnt > rightMajorityCnt ? leftMajority : rightMajority;
    }

    private int occurance(int[] nums, int l, int r, int target) {
        int cnt = 0;
        for (int i = l; i <= r; i++)
            if (nums[i] == target)
                cnt++;
        return cnt;
    }

}
