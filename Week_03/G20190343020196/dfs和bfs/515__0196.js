/*
 * @lc app=leetcode.cn id=515 lang=javascript
 *
 * [515] 在每个树行中找最大值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */

//bfs: 利用队列存入每层节点。外循环遍历层级。内循环遍历当前层的节点
/* var largestValues = function (root) {
    if (!root) return [];
    
    //每层的最大值
    let result = [];
    //遍历每层的节点list
    let list = [root];

    //外循环 遍历层级
    while (list.length != 0) {
        //最大值
        let subResultMax = -Infinity;
        //获取当前节点的子节点
        let nextSubResult = [];

        //内循环遍历节点，并将子节点存入nextSubResult
        for (let i = 0; i < list.length; i++) {

            let curr = list[i];

            //Math.max获取最大值
            subResultMax = Math.max(subResultMax, curr.val);

            if (curr.left != null) {
                nextSubResult.push(curr.left);
            }
            if (curr.right != null) {
                nextSubResult.push(curr.right);
            }
        }
        //将最大值插入result
        result.push(subResultMax);
        //更新list
        list = nextSubResult;
    }
    return result;
}; */

//dfs
var largestValues = function (root) {
    if (!root) return [];
    let result = [];
    dfs(root, 0, result);
    return result;

}


function dfs(curr, level, result) {
    if (curr != null) {

        //空值时
        if (result[level] == undefined) {
            result[level] = curr.val;
        } else {
            result[level] = Math.max(curr.val, result[level]);
        }

        if (curr.left != null) {
            dfs(curr.left, level + 1, result);
        }
        if (curr.right != null) {
            dfs(curr.right, level + 1, result)
        }
    }
}






// @lc code=end