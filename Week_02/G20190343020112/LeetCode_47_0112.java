class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int length;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return new ArrayList();
        this.length = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        return backtrack(0, new ArrayList<>(), new boolean[this.length]);
    }

    private List<List<Integer>> backtrack(int len, List<Integer> list, boolean[] used) {
        if (len == length) {
            res.add(new ArrayList<>(list));
            return res;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i-1])  continue;
            list.add(nums[i]);
            used[i] = true;
            backtrack(len + 1, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }

        return res;
    }
}