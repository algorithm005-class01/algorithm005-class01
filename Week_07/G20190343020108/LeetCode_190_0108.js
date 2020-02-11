/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let res = 0;
    for (let i = 0; i < 32; i++) {
        res <<= 1; // res 左移空出位置
        res |= n & 1; // 添加 n 的最低位
        n >>= 1; // 右移去掉最低位
    }
    return res >>> 0;
};
