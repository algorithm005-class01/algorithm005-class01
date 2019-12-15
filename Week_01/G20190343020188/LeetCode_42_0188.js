/**
 * https://leetcode-cn.com/problems/trapping-rain-water/submissions/
 * @param {number[]} height
 * @return {number}
 */

// 栈
var trap = function(height) {
  var ans = 0;
  var current = 0;
  var stack = [];
  while (current < height.length) {
    while (stack.length !== 0 && height[current] > height[stack[0]]) {
      var top = stack[0];
      stack.shift();
      if (stack.length === 0) break;
      var distance = current - stack[0] - 1;
      var bounded_height = Math.min(height[current], height[stack[0]]) - height[top];
      ans += distance * bounded_height;
    }
    stack.unshift(current++);
  }
  return ans;
};

// 双指针
var trap = function(height) {
  var left = 0;
  var right = height.length - 1;
  var ans = 0;
  var left_max = 0;
  var right_max = 0;
  while (left < right) {
    if (height[left] < height[right]) {
      height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
        ++left;
    }
    else {
      height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
        --right;
    }
  }
  return ans;
};