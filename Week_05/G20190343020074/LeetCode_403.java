class Solution {
    public boolean canCross(int[] A) {
        int n = A.length;
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();
        int i, j;
        for (i = 0; i < n; i++) {
            dp.put(A[i], new HashSet<>());
        }
        dp.get(A[0]).add(0);
        for (i = 0; i < n; i++) {
            HashSet<Integer> Si = dp.get(A[i]);
            for (Integer k : Si) {
                //j = current jump
                for (j = k - 1; j <= k + 1; j++) {
                    if (j <= 0) {
                        continue;
                    }
                    if (dp.containsKey(A[i] + j)) {
                        dp.get(A[i] + j).add(j);
                    }
                }
            }
        }
        return !dp.get(A[n - 1]).isEmpty();
    }
}
