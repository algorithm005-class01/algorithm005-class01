/** 解法一
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    let ans = Array.from({ length: num + 1 }).fill(0);
    for (let i = 1; i <= num; i++) {
        ans[i] = (i & 1) == 1 ? ans[i - 1] + 1 : ans[i >> 1];
    }
    return ans;
};

/**
 * 解法二
 * @param {number} num
 * @return {number[]}
 */
// var countBits1 = function(num) {
//     let res = [0];
//     let n = 1;
//     while (n <= num) {
//         let tmp = n;
//         res.push(res[tmp >> 1] + (tmp & 1));
//         n++;
//     }
//     return res;
// };

/**
 * 解法二的另一种写法
 * @param {number} num
 * @return {number[]}
 */
// var countBits2 = function(num) {
//     let ans = Array.from({ length: num + 1 }).fill(0);
//     for (let i = 1; i <= num; i++) {
//         ans[i] = ans[i >> 1] + (i & 1);
//     }
//     return ans;
// };
