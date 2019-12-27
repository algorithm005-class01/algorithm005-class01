class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int length;
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return new ArrayList();
        this.length = nums.length;
        List<Integer> list = new ArrayList<>();
        for ( int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        return backtrack(0, list);
    }

    private List<List<Integer>> backtrack(int first, List<Integer> list) {
        if (first == length) {
            res.add(new ArrayList<Integer>(list));
            return res;
        }
        for (int i = first; i < length; i++) {
            Collections.swap(list, first, i);
            backtrack(first + 1, list);
            Collections.swap(list, first, i);
        }
        return res;
    }
}