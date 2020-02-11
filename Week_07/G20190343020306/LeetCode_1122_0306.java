class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];

        //数的范围以及数的出现次数
        int[] nums = new int[1001];

        //arr1计数
        for (int v: arr1) {
            nums[v]++;
        }

        int i = 0;
        //arr2反向减, 因为arr2所有的值都在arr1出现过, 那么直接减即可, 每减一次就加一个值到ans里面
        for (int v2: arr2) {
            while (nums[v2]-- > 0) {
                ans[i++] = v2;
            }
        }
        //arr1剩余部分加入ans, 按数组下标走肯定是有序的
        for (int j = 0; j < nums.length; j++) {
            while (nums[j]-- > 0) {
                ans[i++] = j;
            }
        }

        return ans;

    }
}