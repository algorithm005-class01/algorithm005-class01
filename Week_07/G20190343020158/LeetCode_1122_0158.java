class Solution {

    /**
     * 思路：通过计数排序，记录arr1中数字出现的个数，并放到一个额外的数组中，
     * 再跟据arr2数组中的数字顺序将结果输出到返回数组中
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] nums = new int[1001];
        int[] res = new int[arr1.length];
        for (int num : arr1) {
            nums[num]++;
        }

        int index = 0;
        for (int num : arr2) {
            while (nums[num] > 0) {
                res[index++] = num;
                nums[num]--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0) {
                res[index++] = i;
                nums[i]--;
            }
        }

        return res;
    }
}