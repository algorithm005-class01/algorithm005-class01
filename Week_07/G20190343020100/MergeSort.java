package week07;

public class MergeSort {
    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;
        //二分
        int mid = (left + right) >> 1;

        //sort
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //建立存放两个合并所需的临时数组
        int[] tmp = new int[right - left];
        int i = left, j = mid + 1, k = 0;

        //两个数组合并  ps：一定会有一个数组会单
        while (i<= mid && j <= right) {
            tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        //处理剩下的
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];

        //从tmp赋值回原来arr
        for (int p = 0; p < tmp.length; p++) {
            arr[left + p] = tmp[p];
        }
    }

}
