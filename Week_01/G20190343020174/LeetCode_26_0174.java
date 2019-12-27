public class LeetCode_26_0190 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return length;
        }
        int i = 1;
        for (int n : nums)
            if (n > nums[i - 1]){
                nums[i++] = n;
            }
        return i;
    }
}