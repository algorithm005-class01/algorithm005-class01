class Solution {
    public void moveZeroes(int[] nums) {
        //先统计一遍非0元素的个数, 顺便把非0元素都放在首部
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //数组前面j个元素都是非0元素
        //把最后的元素置为0
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }

    }
}