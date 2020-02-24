package week_07.commit;

// 231. 2的幂
// https://leetcode-cn.com/problems/power-of-two/
public class Solution_231_01 {

    public boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo2(n/2)));

    }

    public boolean isPowerOfTwo3(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }

    public boolean isPowerOfTwo4(int n) {
        return n > 0 && (1073741824 % n == 0);

    }

    public boolean isPowerOfTwo5(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
