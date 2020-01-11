/*
 * @lc app=leetcode.cn id=78 lang=javascript
 *
 * [78] 子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */

//DFS， 到底回递 + 栈，将每次到底的pop出来
var subsets = function (nums) {
    var result = [];
    var subsets = [];

    //数组长度
    var len = nums.length;

    (function combinate(subsets, index) {
        //terminator
        if (index == len) {
            //[],[3],[2],[1],
            result.push(subsets);
            return;
        }

        //process
        //drill down
        //收集数组每个元素的集合，每个元素开始往下递归
        combinate(subsets, index + 1);
        subsets.push(nums[index]);
        let newSub = subsets.slice(0);
        combinate(newSub, index + 1);

        //reverse states
        subsets.pop();
    })(subsets, 0);
    return result;
};

//解法2
/* var subsets = function(nums) {
    let ws = [[]];
    for(let i=0; i < nums.length; ++i) {
        for(let j=0, len = ws.length; j < len; ++j) {
            ws.push(ws[j].concat([nums[i]]));
        }
    }
    return ws;
}; */

// @lc code=end