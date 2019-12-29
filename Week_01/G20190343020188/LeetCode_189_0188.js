/**
 * https://leetcode-cn.com/problems/rotate-array/
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

// 使用额外数组
var rotate = function(nums, k) {
  var tmp = new Array(nums.length);
  for (var i = 0; i < nums.length; i++) {
    tmp[(i + k) % nums.length] = nums[i];
  }
  for (var i = 0; i < nums.length; i++) {
    nums[i] = tmp[i];
  }
};

// 循环替换
var rotate = function(nums, k) {
  k = k % nums.length;
  var count = 0;
  for (var start = 0; count < nums.length; start++) {
    var current = start;
    var prev = nums[start];
    do {
      var next = (current + k) % nums.length;
      var temp = nums[next];
      nums[next] = prev;
      prev = temp;
      current = next;
      count++;
    } while (start != current);
  }
};

// 反转
var rotate = function(nums, k) {
  k %= nums.length;

  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length - 1);
};

function reverse(nums, start, end) {
  while (start < end) {
    var temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
    start++;
    end--;
  }
}