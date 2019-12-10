class Solution {
    /**因为移动k位，所以最后k（假设k<n)位的尾数组会移动到头部，后面n-k位向后移动k位。
     * 所以直接把整个数组反转就把最后k位移动到了头部，后面的n-k自然移动到了尾部。但是反转后的数组顺序反了，
     * 所以再将前面k位和后n-k位分别再做一次反转
     * @param nums
     * @param k
     */

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    }

    private void rotate (int[] nums,int start, int end) {
        while (start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}