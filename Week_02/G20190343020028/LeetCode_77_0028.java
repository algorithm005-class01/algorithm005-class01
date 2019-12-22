//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int k;
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        // 从 1 开始验证
        backtrace(1, new LinkedList<>());
        return result;
    }

    public void backtrace(int first, LinkedList<Integer> current) {
        // 当前计数桶已满，则新增计数桶
        if (current.size() == k) {
            result.add(new LinkedList<>(current));
        }
        // 退出条件：i > n 时退出
        for (int i = first; i <= n; i++) {
            // 当前节点处理
            current.add(i);
            // 向下递归添加验证
            backtrace(i + 1, current);
            // 回溯后，把最后一位移除
            current.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
