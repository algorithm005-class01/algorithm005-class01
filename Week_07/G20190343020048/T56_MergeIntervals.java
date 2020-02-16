package main.leetcode_solutions.sort;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/9 10:50 PM
 */
public class T56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }
        //sort
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);

        //merge
        for (int[] interval : intervals){
            if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else{
                newInterval = interval;
                res.add(newInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
