class Solution {
    /**
     * 思路：n为2的幂次方，则代表n的二进制数中只有一个1，n & (n - 1) 则为0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}