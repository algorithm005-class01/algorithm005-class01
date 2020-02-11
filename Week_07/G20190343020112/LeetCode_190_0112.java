public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res |= (((n >> (31 - i)) & 1) << i);
        }
        return res;
    }
}