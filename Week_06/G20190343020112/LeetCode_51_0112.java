class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        char[] cs = new char[n];
        Arrays.fill(cs, '.');
        backtrack(cs, 0, n, new LinkedList<String>(), new ArrayList<Integer>());   

        return res;
        
    }

    private void backtrack(char[] cs, int i, int n, LinkedList<String> ans, List<Integer> exist) {
        if (i == n) {
            res.add(new ArrayList<String>(ans));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(i, j, n, exist)) {
                cs[j] = 'Q';
                ans.add(String.valueOf(cs));
                cs[j] = '.';
                exist.add(j);
                backtrack(cs, i + 1, n, ans, exist);
                exist.remove(exist.size() - 1);
                ans.removeLast();
            } 
        }
    }

    private boolean isValid(int i, int j, int n, List<Integer> exist) {
        for (int k = 0; k < i; k++) {
            int e = exist.get(k);
            if (e == j || e + (i - k) == j || e - (i - k) == j) return false;
        }

        return true;
    }
}