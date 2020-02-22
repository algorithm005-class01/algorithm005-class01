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


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        combine(n, 1, k, combine, lists);
        return lists;
    }

    private void combine (int n, int start, int k, List<Integer> combine, List<List<Integer>> lists) {
        if (k==0) {
            lists.add(new ArrayList<Integer>(combine));
            return;
        }
        for (int i = start; i<=n; i++) {
            combine.add(i);
            combine(n, i+1, k-1, combine, lists);
            combine.remove(combine.size()-1); //重置状态
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
