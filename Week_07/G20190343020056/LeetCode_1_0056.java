class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int min = arr1[0], max = arr1[0];
        int i = 1;
        for(; i < arr1.length; i++) {
            if(arr1[i] < min) {
                min = arr1[i];
            }
            if(arr1[i] > max) {
                max = arr1[i];
            }
        }
        int[] tmp = new int[max - min + 1];
        for(i = 0; i < arr1.length; i++) {
            tmp[arr1[i] - min]++;
        }
        int[] res = new int[arr1.length];
        int index = 0, count = 0;
        for(i = 0; i < arr2.length; i++) {
            count = tmp[arr2[i] - min];
            while(count-- > 0) {
                res[index++] = arr2[i];
            }
            tmp[arr2[i] - min] = 0;
        }
        for(i = 0; i < tmp.length; i++) {
            count = tmp[i];
            while(count-- > 0) {
                res[index++] = i + min;
            }
        }
        return res;
    }
}