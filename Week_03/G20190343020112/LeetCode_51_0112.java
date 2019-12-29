class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        char[] cs = new char[n];
        Arrays.fill(cs, '.');
        int[] history = new int[n];
        Arrays.fill(history, -1);
        return backtrack(res, new ArrayList<String>(), 0, n, cs, history);
    }

    private List<List<String>> backtrack(List<List<String>> res, 
                                        List<String> list, 
                                        int col, 
                                        int n,
                                        char[] cs,
                                        int[] history) {
        if (col == n) {
            res.add(new ArrayList<String>(list));
            return res;
        }

        for (int i = 0; i < n; i++) {
            if (disable(history, col, i, n)) continue;
            cs[i] = 'Q';
            list.add(String.valueOf(cs));
            cs[i] = '.';
            history[col] = i;
            backtrack(res, list, col + 1, n, cs, history);
            history[col] = -1;
            list.remove(list.size() - 1);
        }
        return res;
    }

    private boolean disable(int[] history, int col, int i, int n) {
        for (int j = col - 1; j >= 0; j--) {
            if (history[j] == i) return true;
            int k;
            if ((k = i - col + j) >= 0 && history[j] == k) return true;
            if ((k = i + col -j) < n && history[j] == k) return true;
        }
        return false;
    }

}