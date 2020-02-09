// 解法一：2的幂数的数字的二进制特点 + 位操作
var isPowerOfTwo = function(n) {
    return n > 0 && (n & (n-1)) == 0;
};