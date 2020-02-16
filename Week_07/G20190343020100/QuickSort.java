package week07;

public class QuickSort {

    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        //寻找标杆
        int pivot = partition(arr, begin, end);
        //分治-自顶向下
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        //标杆在哪不重要，可以是头，尾，中间
        int pivot = end, counter = begin;

        for (int i = begin; i < end; i++) {
            //当arr[i] 比 标杆小 ，就往左交换，包装比标杆小的都在左边
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        //最后把标杆移动到counter位置，完整一次整理
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;

        return counter;
    }
}
