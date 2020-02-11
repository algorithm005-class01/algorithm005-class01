public class Solution {

    public int reverseBits(int n) {
        int mask = 1;
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse = (reverse << 1) + ((n & mask) == 0 ? 0 : 1);
            mask <<= 1;
        }
        return reverse;
    }

}