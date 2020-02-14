class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length -1);
    }

    private int mergeSort (int[] array, int left, int right) {
        if(left >= right) return 0;
        int mid = ((left + right) >> 1);// / 1;
        int count = mergeSort(array, left, mid) + mergeSort(array, mid+1, right);

        for(int i = left, j = mid +1; i <= mid; i++) {
            while(j <= right && array[i]/2.0 > array[j]) j++;
            count += j - (mid +1);
        }

        System.out.println("count = " + count);
        Arrays.sort(array, left, right +1);
        return count;
    }
}