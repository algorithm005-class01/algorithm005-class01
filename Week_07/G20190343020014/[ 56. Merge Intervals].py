class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if len(intervals) == 0:
            return []
        intervals = sorted(intervals, key=lambda x: x.start)
        res = [intervals[0]]
        for n in intervals[1:]:
            if n.start <= res[-1].end:
                res[-1].end = max(n.end, res[-1].end)
            else:
                res.append(n)
        return res
