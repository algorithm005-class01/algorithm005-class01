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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        // 将二维数组按照左区间排序
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        // 将第一个区间先加入结果集
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            // 如果和前一个区间重合，则合并
            if (interval[0] <= newInterval[1]) {
                // 右区间置为两合并区间的最大值
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // 如果未重合，则将该区间当做一个独立区间加入结果集
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
