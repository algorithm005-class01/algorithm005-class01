/*
 * @lc app=leetcode.cn id=433 lang=javascript
 *
 * [433] 最小基因变化
 */

// @lc code=start
/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */

//bfs:从左到右， 使用queue辅助

var minMutation = function (start, end, bank) {
    if (start == end) return 0;

    //new 基因库，判断end是否存在
    var bankSet = new Map();
    for (let i = 0; i < bank.length; i++) {
        bankSet.set(bank[i], true);
    }

    var genes = ['A', 'C', 'G', 'T'];
    var level = 0;

    //存start, 和变化次数
    var queue = [
        [start, 0]
    ];

    //队列不为空
    while (queue.length != 0) {
        //尾出
        var curr = queue.pop();
        level = curr[1];

        //输出结果
        if (curr[0] == end) {
            return level;
        }

        var arrCurr = curr[0];

        //遍历队列最新的curr[0]，替换新的字符，且判断是否符合bank
        for (let i = 0; i < arrCurr.length; i++) {
            for (let r = 0; r < genes.length; r++) {
                //替换字符
                if (genes[r] != arrCurr[i]) {
                    let strCurr = (arrCurr.slice(0, i)) + genes[r] + (arrCurr.slice(i + 1));

                    //替换后相等，更新队列，且把bank相同的删除，免得下个循环误判
                    if (bankSet.has(strCurr)) {
                        queue.unshift([strCurr, level + 1]);
                        bankSet.delete(strCurr);
                    }
                }
            }
        }
    }
    return -1;
};
// @lc code=end