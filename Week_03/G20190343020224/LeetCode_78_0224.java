//1.回溯
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        trackback(0, nums, new ArrayList<>(), output);
        return output;
    }

    public void trackback(int start, int[] nums, List<Integer> subset, List<List<Integer>> output) {
        if (start == nums.length) {
            output.add(new ArrayList<>(subset));
            return;
        }
        trackback(start + 1, nums, subset, output);
        subset.add(nums[start]);
        trackback(start + 1, nums, subset, output);
        subset.remove(subset.size() - 1);
    }
}
//2.循环
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newOutput = new ArrayList<>();
            for (List<Integer> subset : output) {
                List<Integer> newSubSet = new ArrayList<>(subset);
                newSubSet.add(num);
                newOutput.add(newSubSet);
            }
            output.addAll(newOutput);
        }
        return output;
    }

}