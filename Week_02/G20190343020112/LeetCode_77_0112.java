class Solution {
    int n, k;
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return res;
    }

    private void backtrack(int first, List<Integer> list) {
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = first; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrack(i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}