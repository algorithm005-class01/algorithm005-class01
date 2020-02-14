//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        System.out.println(Arrays.deepToString(solution.merge(
                new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 6},
                        new int[]{8, 10},
                        new int[]{15, 18},
                }
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return intervals;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> list = new ArrayList<>();
            list.add(intervals[0]);
            for (int[] interval : intervals) {
                int[] last = list.get(list.size() - 1);
                if (last[1] < interval[0]) {
                    list.add(interval);
                } else {
                    last[1] = Math.max(last[1], interval[1]);
                }
            }
            int[][] res = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}