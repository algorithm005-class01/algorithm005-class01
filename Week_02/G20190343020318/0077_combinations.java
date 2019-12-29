class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        dfs(n, k, res, new ArrayList<Integer>(), 1); //  1 - n
        return res;
    }
    
    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> subset, int index) {
        if (subset.size() == k) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = index; i <= n; ++i) {
            subset.add(i);
            dfs(n, k, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}