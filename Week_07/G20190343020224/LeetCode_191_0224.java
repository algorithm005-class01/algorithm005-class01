public class Solution {

    /* 注意每位比较的时候不要改变n，要改变mask，不然n右移操作会改变其他位 */

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 1; i <= 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

}