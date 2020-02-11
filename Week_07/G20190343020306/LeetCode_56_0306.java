class IntervalComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) { return new int[0][]; }
        List<int[]> intervalList = new ArrayList<>();
        for (int[] interval: intervals) {
            intervalList.add(interval);
        }
        Collections.sort(intervalList, new IntervalComparator());

        List<int[]> answerList = new ArrayList<>();
        answerList.add(intervalList.get(0));

        for (int i = 1; i < intervalList.size(); i++) {
            if (isOverlapped(answerList.get(answerList.size() - 1), intervalList.get(i))) {
                answerList.set(answerList.size() - 1, new int[] {
                        answerList.get(answerList.size() - 1)[0],
                        Math.max(answerList.get(answerList.size() - 1)[1], intervalList.get(i)[1]) });
            } else {
                answerList.add(intervalList.get(i));
            }
        }

        return answerList.toArray(new int[answerList.size()][2]);
    }

    private boolean isOverlapped(int[] first, int[] second) {
        return first[1] >= second[0];
    }
}