class RemoveDuplicatesFromSortedArray {

    class Solution {

        //双指针：快慢指针 用带索引的for循环要考虑越界，用foreach不用
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int index = 0;
            for (int i: nums) {
                if (i > nums[index]) {
                    nums[++index] = i;
                }
            }
            return index + 1;
        }

    }

}