/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  // 迭代 队列辅助 94.38% 100%
  let ans = [], queue = [], q = [], cur = root,
      level = 0, len = 0
  if(cur) {
    queue.push([cur,0])
  }
  while(queue.length > 0) {
    cur = queue.shift()
    if(!ans[cur[1]]) {
      ans[cur[1]] = []
    }
    ans[cur[1]].push(cur[0].val)
    len = cur[0].children ? cur[0].children.length : 0
    for(let i = 0; i < len; i++) {
      queue.push([cur[0].children[i],cur[1] + 1])
    }
  }
  return ans
};
// @lc code=end

