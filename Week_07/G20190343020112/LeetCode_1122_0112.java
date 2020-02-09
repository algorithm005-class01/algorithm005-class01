class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int a : arr1) {
            count[a]++;
        }
        int index = 0;
        for (int a : arr2) {
            while(count[a]-- > 0) {
                arr1[index++] = a;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}