class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}

// class Solution {
//     public int[] countBits(int num) {
//         int[] res = new int[num + 1];

//         for (int i = 1; i <= num; i++) {
//             int n = i, count = 0;
//             while(n != 0) {
//                 count++;
//                 n &= (n - 1);
//             }
//             res[i] = count;
//         }
//         return res;
//     }
// }