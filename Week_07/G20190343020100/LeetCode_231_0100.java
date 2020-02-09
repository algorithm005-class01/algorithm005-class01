package week07;

public class LeetCode_231 {
    //就是判断末尾是 0 还是 1
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
