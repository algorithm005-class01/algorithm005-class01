class MoveZeroes {

    class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[index];
                    nums[index++] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

}