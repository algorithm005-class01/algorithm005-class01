class RotateArray {

    //1.暴力 O(n)
    class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            if (k == 0) {
                return;
            }
            for (int i = 1; i <= k; i++) {
                int cur = nums[nums.length - 1];
                int temp;
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = cur;
                    cur = temp;
                }
            }
        }
    }

    //环状替换 O(n)
    class Solution2 {

        public void rotate(int[] nums, int k) {
            if (nums.length < 2) {
                return;
            }
            k %= nums.length;
            int index = 0;
            int count = 0;
            while (index < nums.length && count < nums.length) {
                int start = index;
                int curVal = nums[start];
                int cur = index;
                do {
                    cur = (cur + k) % nums.length;
                    int temp = nums[cur];
                    nums[cur] = curVal;
                    curVal = temp;
                    count++;
                } while (start != cur);
                index++;
            }
        }

    }

    //翻转 O(n)
    class Solution2 {

        public void rotate(int[] nums, int k) {
            if (nums.length < 2) {
                return;
            }
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

}