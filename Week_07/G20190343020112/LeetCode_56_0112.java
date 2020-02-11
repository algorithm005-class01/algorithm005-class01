class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, (int[] a1, int[] a2)->{
            return a1[0] - a2[0];
        });

        List<int[]> list = new ArrayList<>();
        int[] arr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= arr[1]) continue;
            if (intervals[i][0] <= arr[1]) {
                arr[1] = intervals[i][1];
            }
            if (intervals[i][0] > arr[1]) {
                list.add(arr);
                arr = intervals[i];
            }
        }
        list.add(arr);
        return list.toArray(new int[list.size()][]);
    }
}