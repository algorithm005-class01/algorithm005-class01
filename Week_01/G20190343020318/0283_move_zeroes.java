class Solution {
    public void moveZeroes(int[] a) {
        for (int i = 0, j = 0; i < a.length; ++i) {
            if (a[i] != 0) {
                a[j] = a[i];
                if (i != j) {
                    a[i] = 0;
                } 
                ++ j;
            }
        }
    }
}