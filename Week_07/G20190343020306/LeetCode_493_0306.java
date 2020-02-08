class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    //归并排序后返回逆序对个数
    private int mergeSort(int[] array, int left, int right) {
        if (right <= left) { return 0; }
        int mid = (left + right) >> 1;

        int leftNumber = mergeSort(array, left, mid);
        int rightNumber = mergeSort(array, mid + 1, right);

        int mergedNumber = merge(array, left, mid, right);

        return leftNumber + rightNumber + mergedNumber;
    }

    private int merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, t = left, j = mid + 1, k = 0, reverseCount = 0;
        while (j <= right) {
            //固定j, 首先统计2倍逆序对的个数, 先跳过不满足统计条件的部分, 剩余部分都是满足统计条件的
            while (i <= mid && array[i] <= 2 * (long) array[j]) { i++; }
            //正常的归并, 小于当前array[j]的放入temp
            while (t <= mid && array[t] < array[j]) { temp[k++] = array[t++]; }
            reverseCount += mid - i + 1;
            temp[k++] = array[j++];
        }

        //剩余的i继续迭代完
        while (t <= mid) {
            temp[k++] = array[t++];
        }

        System.arraycopy(temp, 0, array, left, right - left + 1);

        return reverseCount;
    }
}