/**
 * https://leetcode-cn.com/problems/two-sum/
 * 
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  // 创建字典缓存
  var map = new Map();

  // 缓存数组长度
  var len = nums.length;

  // 遍历数组
  for(var i = 0;i<len;i++){
    // 取差值
    var t = target - nums[i];

    // 检查 map 中有没有符合差值的数字
    if(map.has(t)) return [map.get(t), i];

    // 将数字存入缓存
    map.set(nums[i], i);
  }
};