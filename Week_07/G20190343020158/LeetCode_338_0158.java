class Solution {
    /**
     * 思路：与191题类似，通过 n & (n - 1) 能统计出1的个数
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                count++;
                temp &= (temp - 1);
            }
            res[i] = count;
        }
        return res;
    }
}