/**
 * https://leetcode-cn.com/problems/combinations/
 * 
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  if(n == 0 || k == 0 || k > n) return [];

  var res = [];

  // 个数为1的所以可能
  for(var z = 1;z <= n+1-k;z++){
      res.push([z]);
  }
  // 第一层循环，从 2 到 k，直到k符合题意
  for(var i = 2;i <= k;i++){
    var tmp = [];
    // 第二层循环，遍历之前的所有结果
    for(var r = 0;r <res.length;r++){
      // 第三层循环，继续扩展组合集合，每次增加一个数
      // 此处s <= n-(k-(i-1))+1类似解法一的优化版不必循环到n
      // k - 当前组合的个数 = 还需要的数字个数 
      // (k-(i-1)) == 还需要的数字个数，i-1因为第一个只有一个数字的所有组合已经确定
      // n - 还需要的数字个数 + 1  == 遍历的末尾索引值，+1是因为第n个数也可以取(如n=5：1，2，3，4，5)
      for(var s = res[r][res[r].length-1]+1;s <= n-(k-(i-1))+1;s++){
        var tmpB = [].concat(res[r]);
        tmpB.push(s);
        tmp.push(tmpB);
      }
    }
    res = tmp;
  }
  return res;
}