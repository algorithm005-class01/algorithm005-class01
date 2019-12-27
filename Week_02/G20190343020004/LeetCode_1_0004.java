public class LeetCode_1_0004 {

    public int[] twoSum(int[] nums, int target) {
        if (nums != null && nums.length > 1) {
            int i = 0;
            int j = i + 1;
            while (i < nums.length - 1) {
                j = i + 1;
                while (j < nums.length) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                    while (j < nums.length - 1 && nums[j] == nums[++j]) ;
                }
                while (i < nums.length - 1 && nums[i] == nums[++i]) ;
            }
        }
        return null;
    }
}
