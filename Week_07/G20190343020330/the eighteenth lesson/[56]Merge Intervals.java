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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> res = new LinkedList<Interval>();

        for (Interval interval : intervals) {
            if (res.isEmpty() || res.getLast().end < interval.start) {
                res.add(interval);
            } else {
                res.getLast().end = Math.max(res.getLast().end, interval.end);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
