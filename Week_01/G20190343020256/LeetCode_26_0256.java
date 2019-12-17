package Week0;

public class LeetCode_26_0256 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int repeatNum = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length ; i++) {
            if (repeatNum != nums[i]) {
                repeatNum = nums[i];
                index++;
                nums[index] = nums[i];
            }
        }

        return index+1;
    }
}
