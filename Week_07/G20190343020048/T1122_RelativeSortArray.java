package main.leetcode_solutions.sort;

/**
 * @author wenzhuang
 * @date 2020/2/9 9:57 PM
 */
public class T1122_RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[10001];
        for (int i = 0; i < arr1.length; i++){
            bucket[arr1[i]]++;
        }
        int k = 0;
        for (int j = 0; j < arr2.length; j++){
            while (bucket[arr2[j]]-- > 0 ){
                arr1[k++] = arr2[j];
            }
        }
        for (int p = 0;  p <= 1000; p++){
            while (bucket[p]-- > 0){
                arr1[k++] = p;
            }
        }
        return arr1;
    }
}
