class Solution {
    public int removeDuplicates(int[] a) {
        if (a == null || a.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < a.length) {
            if (a[q] > a[p]) {
                a[p + 1] = a[q];
                ++ p;
            }
            ++ q;
        }        
        return p + 1;
    }
}