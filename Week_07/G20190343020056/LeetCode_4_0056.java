class Solution {
    public int[][] merge(int[][] intervals) {
               for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] < intervals[i][0]) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int[] item : intervals) {
            if (list.isEmpty() || list.get(list.size() - 1)[1] < item[0]) {
                list.add(item);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], item[1]);
            }
        }

        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] item : list) {
            result[index] = item;
            index++;
        }
        return result;
    }
}
