class Solution {
    public int removeDuplicates(int[] nums) {
        /**
         * 思考：该题主要使用的是双指针的方法，一个指针代表去重后数据要填充的位置（index），另一个为向后遍历的指针（i）
         * 根据题意，数组已排序过，重复数据必定相邻，所以可直接按顺序进行遍历，
         * index开始保持不变，i向后遍历，只有当index所在位置的数据与i所在数据不同时，将i数据移到index所在位置的下一位，并且index+1
         */
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}