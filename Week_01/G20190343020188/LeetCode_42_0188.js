/**
 * https://leetcode-cn.com/problems/trapping-rain-water/submissions/
 * @param {number[]} height
 * @return {number}
 */
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