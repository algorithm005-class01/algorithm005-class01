package G20190343020220.leetcode_77_0220;
/*
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * @author Darcy
 * @date 2019-12-20 17:33
 */
public class Sulotion {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (n == 0 || k <= 0 || k > n) {
            return res;
        }
        combineHelper(res, new ArrayList<>(), 1, n, k);
        return res;

    }

    private void combineHelper(List<List<Integer>> res, ArrayList<Integer> objects, int start, int n, int k) {
        if (k == objects.size()) {
            res.add(new ArrayList<>(objects));
        }
        for (int i = start; i <= n - (k - objects.size()) + 1; i++) {
            objects.add(i);
            this.combineHelper(res, objects, i + 1, n, k);
            objects.remove(objects.size() - 1);
        }
    }
}
