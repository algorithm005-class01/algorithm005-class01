public class Solution {

    /* 注意：必须是正数 */

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

}