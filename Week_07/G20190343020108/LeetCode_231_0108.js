/**
 * 解法一：位运算: 利用 n & (-n) 获取二进制中最右边（最低位）的1
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    return n > 0 && (n & -n) == n;
};

/**
 * 解法二：位运算: 利用 n & (n - 1) 清除二进制中最右边（最低位）的1
 * @param {number} n
 * @return {boolean}
 */
// var isPowerOfTwo1 = function(n) {
//     return n > 0 && (n & (n - 1)) == 0;
// };

/**
 * 解法三：如果是2的幂，一直除以2后会变为1，否则小于1；JS 中的 Number是浮点数
 * @param {number} n
 * @return {boolean}
 */
// var isPowerOfTwo2 = function(n) {
//     while (n > 1) n /= 2;
//     return n == 1;
// };

/**
 * 解法四：直接调用库函数
 * @param {number} n
 * @return {boolean}
 */
// var isPowerOfTwo3 = function(n) {
//     return Number.isInteger(Math.log2(n));
// };
