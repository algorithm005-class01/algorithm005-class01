// 解法二：位运算
var isPowerOfTwo = function(n) {
    return n > 0 && (n & (-n)) == n
};