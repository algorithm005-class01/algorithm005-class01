/**
 * 解法一：使用循环和位移动
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0;
    let mask = 1;
    for (let i = 0; i < 32; i++) {
        if ((n & mask) !== 0) count++;
        mask <<= 1; // 左移1位
    }
    return count;
};

/**
 * 解法二：使用 n & (n - 1) 将最低位的 1 变为 0
 * @param {number} n - a positive integer
 * @return {number}
 */
// var hammingWeight1 = function(n) {
//     let count = 0;
//     while (n != 0) {
//         count++;
//         n &= n - 1;
//     }
//     return count;
// };

/**
 * 解法三：使用 toString(2)转二进制，然后正则匹配 1 出现的次数
 * @param {number} n - a positive integer
 * @return {number}
 */
// var hammingWeight2 = function(n) {
//     return (n.toString(2).match(/1/g) || []).length;
// };

/**
 * 解法四：十进制转二进制取模
 * @param {number} n - a positive integer
 * @return {number}
 */
// var hammingWeight3 = function(n) {
//     let count = 0;
//     while (n) {
//         if (n & 1 === 1) count++;
//         n >>>= 1; // 无符号右移往左边填充0
//     }
//     return count;
// };
